/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var app = angular.module('je-master-pengirim-controller', [
			'je-master-pengirim-service',
			'ui.bootstrap', 'dialogs' ]);

	app.controller('PengirimListController', [ '$scope', '$location',
			'$dialogs', 'PengirimListFactory','PengirimEditFactory',
			function($scope, $location, $dialogs, PengirimListFactory,PengirimEditFactory) {

				$scope.currentPage = 1;
				$scope.totalPengirim = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = PengirimListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.pengirimList = data.list;
						notif($dialogs, data.status, 'List');
						$scope.totalPengirim = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/master/pengirim/new');
				};
				
			   $scope.remove = function (pengirim) {
		        	dlg = $dialogs.confirm('Konfirmasi','Apakah anda ingin hapus Pengirim ini : ' + pengirim.nama_pengirim313339);
		        	dlg.result.then(function(btn){
		        		PengirimEditFactory.remove({nip: pengirim.nip_pengirim313339}, function(data){
		        			notif($dialogs, data.status, 'Hapus');
		            		$scope.search();
		    			});
		            	
		            },function(btn){
		              //canceled
		            });
		            
		        };
		        
			    $scope.edit = function (pengirim) {
		            $location.path('/master/pengirim/' + pengirim.nip_pengirim313339 + '/edit');
		        };
		        
		        $scope.detail = function (pengirim) {
		            $location.path('/master/pengirim/' + pengirim.nip_pengirim313339 + '/detail');
		        };

			} ]);
        
        app.controller('PengirimCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'PengirimListFactory',
			function($scope, $routeParams, $location,$dialogs,
					PengirimListFactory) {

				$scope.title = "Buat Baru Pengirim Kurir";
				$scope.isEdit = false;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				$scope.pengirim = {
			
				};
				$scope.save = function() {
					PengirimListFactory.create({
						pengirim : $scope.pengirim
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/pengirim');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/pengirim');
				};

			} ]);
        
        app.controller('PengirimEditController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'PengirimEditFactory',
			'PengirimListFactory',
			function($scope, $routeParams, $location, $dialogs,PengirimEditFactory,
					PengirimListFactory) {

				$scope.title = "Ubah Data Kurir";
				$scope.isEdit = true;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				PengirimEditFactory.show({
					nip : $routeParams.nip
				}, function(data) {
					$scope.pengirim = data.pengirim;
				});

				$scope.save = function() {
					PengirimEditFactory.update({
						nip : $scope.pengirim.nip_pengirim313339,
						pengirim : $scope.pengirim
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/pengirim');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/pengirim');
				};

			} ]);
        
        app.controller('PengirimDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'PengirimEditFactory',
	'PengirimListFactory',
	function($scope, $routeParams, $location, PengirimEditFactory,
			PengirimListFactory) {

		$scope.title = "Info Detail Pengirim Kurir";

		PengirimEditFactory.show({
			nip : $routeParams.nip
		}, function(data) {
			$scope.pengirim = data.pengirim;
		});


		$scope.cancel = function() {
			$location.path('/master/pengirim');
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

