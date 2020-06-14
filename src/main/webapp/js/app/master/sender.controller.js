/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var app = angular.module('je-master-sender-controller', [
			'je-master-sender-service',
			'ui.bootstrap', 'dialogs' ]);

	app.controller('SenderListController', [ '$scope', '$location',
			'$dialogs', 'SenderListFactory','SenderEditFactory',
			function($scope, $location, $dialogs, SenderListFactory,SenderEditFactory) {

				$scope.currentPage = 1;
				$scope.totalSender = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = SenderListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.senderList = data.list;
						notif($dialogs, data.status, 'List');
						$scope.totalSender = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/master/sender/new');
				};
				
			   $scope.remove = function (sender) {
		        	dlg = $dialogs.confirm('Konfirmasi','Apakah anda ingin hapus Sender ini : ' + sender.nama_sender313339);
		        	dlg.result.then(function(btn){
		        		SenderEditFactory.remove({id: sender.id_sender313339}, function(data){
		        			notif($dialogs, data.status, 'Hapus');
		            		$scope.search();
		    			});
		            	
		            },function(btn){
		              //canceled
		            });
		            
		        };
		        
			    $scope.edit = function (sender) {
		            $location.path('/master/sender/' + sender.id_sender313339 + '/edit');
		        };
		        
		        $scope.detail = function (sender) {
		            $location.path('/master/sender/' + sender.id_sender313339 + '/detail');
		        };

			} ]);
        
        app.controller('SenderCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'SenderListFactory',
			function($scope, $routeParams, $location,$dialogs,
					SenderListFactory) {

				$scope.title = "Buat Baru Sender Kurir";
				$scope.isEdit = false;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				$scope.sender = {
			
				};
				$scope.save = function() {
					SenderListFactory.create({
						sender : $scope.sender
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/sender');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/sender');
				};

			} ]);
        
        app.controller('SenderEditController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'SenderEditFactory',
			'SenderListFactory',
			function($scope, $routeParams, $location, $dialogs,SenderEditFactory,
					SenderListFactory) {

				$scope.title = "Ubah Data Member Sender";
				$scope.isEdit = true;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				SenderEditFactory.show({
					id : $routeParams.id
				}, function(data) {
					$scope.sender = data.sender;
				});

				$scope.save = function() {
					SenderEditFactory.update({
						id : $scope.sender.id_sender313339,
						sender : $scope.sender
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/sender');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/sender');
				};

			} ]);
        
        app.controller('SenderDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'SenderEditFactory',
	'SenderListFactory',
	function($scope, $routeParams, $location, SenderEditFactory,
			SenderListFactory) {

		$scope.title = "Info Detail Sender (Member Penerima)";

		SenderEditFactory.show({
			id : $routeParams.id
		}, function(data) {
			$scope.sender = data.sender;
		});


		$scope.cancel = function() {
			$location.path('/master/sender');
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

