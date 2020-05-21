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

	var app = angular.module('je-master-jenis-pengiriman-controller', [
			'je-master-jenis-pengiriman-service',
			'ui.bootstrap', 'dialogs' ]);

	app.controller('JenisPengirimanListController', [ '$scope', '$location',
			'$dialogs', 'JenisPengirimanListFactory','JenisPengirimanEditFactory',
			function($scope, $location, $dialogs, JenisPengirimanListFactory,JenisPengirimanEditFactory) {

				$scope.currentPage = 1;
				$scope.totalJenisPengiriman = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = JenisPengirimanListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.jenisPengirimanList = data.list;
						notif($dialogs, data.status, 'List');
						$scope.totalJenisPengiriman = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/master/jenis-pengiriman/new');
				};
				
			   $scope.remove = function (jenisPengiriman) {
		        	dlg = $dialogs.confirm('Konfirmasi','Apakah anda ingin hapus Jenis Pengiriman ini : ' + jenisPengiriman.nama_service313339);
		        	dlg.result.then(function(btn){
		        		JenisPengirimanEditFactory.remove({id: jenisPengiriman.id_kurir_service313339}, function(data){
		        			notif($dialogs, data.status, 'Hapus');
		            		$scope.search();
		    			});
		            	
		            },function(btn){
		              //canceled
		            });
		            
		        };
		        
			    $scope.edit = function (jenisPengiriman) {
		            $location.path('/master/jenis-pengiriman/' + jenisPengiriman.id_kurir_service313339 + '/edit');
		        };
		        
		        $scope.detail = function (jenisPengiriman) {
		            $location.path('/master/jenis-pengiriman/' + jenisPengiriman.id_kurir_service313339 + '/detail');
		        };

			} ]);
        
        app.controller('JenisPengirimanCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'JenisPengirimanListFactory',
			function($scope, $routeParams, $location,$dialogs,
					JenisPengirimanListFactory) {

				$scope.title = "Buat Baru Jenis Pengiriman Kurir";
				$scope.isEdit = false;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				$scope.jenisPengiriman = {
			
				};
				$scope.save = function() {
					JenisPengirimanListFactory.create({
						jenisPengiriman : $scope.jenisPengiriman
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/jenis-pengiriman');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/jenis-pengiriman');
				};

			} ]);
        
        app.controller('JenisPengirimanEditController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'JenisPengirimanEditFactory',
			'JenisPengirimanListFactory',
			function($scope, $routeParams, $location, $dialogs,JenisPengirimanEditFactory,
					JenisPengirimanListFactory) {

				$scope.title = "Ubah Data Service Kurir";
				$scope.isEdit = true;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				JenisPengirimanEditFactory.show({
					id : $routeParams.id
				}, function(data) {
					$scope.jenisPengiriman = data.jenisPengiriman;
				});

				$scope.save = function() {
					JenisPengirimanEditFactory.update({
						id : $scope.jenisPengiriman.id_kurir_service313339,
						jenisPengiriman : $scope.jenisPengiriman
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/jenis-pengiriman');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/jenis-pengiriman');
				};

			} ]);
        
        app.controller('JenisPengirimanDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'JenisPengirimanEditFactory',
	'JenisPengirimanListFactory',
	function($scope, $routeParams, $location, JenisPengirimanEditFactory,
			JenisPengirimanListFactory) {

		$scope.title = "Info Detail Jenis Pengiriman Kurir";

		JenisPengirimanEditFactory.show({
			id : $routeParams.id
		}, function(data) {
			$scope.jenisPengiriman = data.jenisPengiriman;
		});


		$scope.cancel = function() {
			$location.path('/master/jenis-pengiriman');
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

