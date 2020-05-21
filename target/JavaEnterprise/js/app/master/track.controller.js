/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var app = angular.module('je-master-track-controller', [
			'je-master-track-service',
			'ui.bootstrap', 'dialogs' ]);

	app.controller('TrackListController', [ '$scope', '$location',
			'$dialogs', 'TrackListFactory','TrackEditFactory',
			function($scope, $location, $dialogs, TrackListFactory,TrackEditFactory) {

				$scope.currentPage = 1;
				$scope.totalTrack = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = TrackListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.trackList = data.list;
						notif($dialogs, data.status, 'List');
						$scope.totalTrack = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/master/track/new');
				};
				
			   $scope.remove = function (track) {
		        	dlg = $dialogs.confirm('Konfirmasi','Apakah anda ingin hapus Track Untuk Paket : ' + track.id_paket313339);
		        	dlg.result.then(function(btn){
		        		TrackEditFactory.remove({nip: track.track_id313339}, function(data){
		        			notif($dialogs, data.status, 'Hapus');
		            		$scope.search();
		    			});
		            	
		            },function(btn){
		              //canceled
		            });
		            
		        };
		        
			    $scope.edit = function (track) {
		            $location.path('/master/track/' + track.track_id313339 + '/edit');
		        };
		        
		        $scope.detail = function (track) {
		            $location.path('/master/track/' + track.track_id313339 + '/detail');
		        };

			} ]);
        
        app.controller('TrackCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'TrackListFactory',
			function($scope, $routeParams, $location,$dialogs,
					TrackListFactory) {

				$scope.title = "Buat Baru Track Kurir";
				$scope.isEdit = false;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				$scope.track = {
			
				};
				$scope.save = function() {
					TrackListFactory.create({
						track : $scope.track
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/track');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/track');
				};

			} ]);
        
        app.controller('TrackEditController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'TrackEditFactory',
			'TrackListFactory',
			function($scope, $routeParams, $location, $dialogs,TrackEditFactory,
					TrackListFactory) {

				$scope.title = "Ubah Data Kurir";
				$scope.isEdit = true;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				TrackEditFactory.show({
					nip : $routeParams.nip
				}, function(data) {
					$scope.track = data.track;
				});

				$scope.save = function() {
					TrackEditFactory.update({
						nip : $scope.track.nip_track313339,
						track : $scope.track
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/track');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/track');
				};

			} ]);
        
        app.controller('TrackDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'TrackEditFactory',
	'TrackListFactory',
	function($scope, $routeParams, $location, TrackEditFactory,
			TrackListFactory) {

		$scope.title = "Info Detail Track Kurir";

		TrackEditFactory.show({
			id : $routeParams.id
		}, function(data) {
			$scope.track = data.track;
		});


		$scope.cancel = function() {
			$location.path('/master/track');
		};

	} ]);
    
        function notif($dialogs, status, result) {

		switch (status) {
		case 'OK':
			if (result == 'Simpan') {
				dlg = $dialogs.notify('Informasi', 'Data Sukses Disimpan');
			} else if (result == 'Hapus') {
				dlg = $dialogs.notify('Informasi', 'Data Sukses Dihapus');
			}
			break;
		case '500':
			if (result == 'Simpan') {
				dlg = $dialogs.error('Data Gagal Disimpan');
			} else if (result == 'Hapus') {
				dlg = $dialogs.error('Data Gagal Dihapus');
			}
			break;
		}
	}
    
})();



