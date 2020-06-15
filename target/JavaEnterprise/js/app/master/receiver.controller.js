/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var app = angular.module('je-master-receiver-controller', [
			'je-master-receiver-service',
			'ui.bootstrap', 'dialogs' ]);
                        
	app.controller('ReceiverListController', [ '$scope', '$location',
			'$dialogs', 'ReceiverListFactory','ReceiverEditFactory',
			function($scope, $location, $dialogs, ReceiverListFactory,ReceiverEditFactory) {

				$scope.currentPage = 1;
				$scope.totalReceiver = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = ReceiverListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.receiverList = data.list;
						notif($dialogs, data.status, 'List');
						$scope.totalReceiver = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/master/receiver/new');
				};
				
			   $scope.remove = function (receiver) {
		        	dlg = $dialogs.confirm('Konfirmasi','Apakah anda ingin hapus Receiver ini : ' + receiver.nama_receiver313339);
		        	dlg.result.then(function(btn){
		        		ReceiverEditFactory.remove({id: receiver.id_receiver313339}, function(data){
		        			notif($dialogs, data.status, 'Hapus');
		            		$scope.search();
		    			});
		            	
		            },function(btn){
		              //canceled
		            });
		            
		        };
		        
			    $scope.edit = function (receiver) {
		            $location.path('/master/receiver/' + receiver.id_receiver313339 + '/edit');
		        };
		        
		        $scope.detail = function (receiver) {
		            $location.path('/master/receiver/' + receiver.id_receiver313339 + '/detail');
		        };

			} ]);
        
        app.controller('ReceiverCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'ReceiverListFactory',
			function($scope, $routeParams, $location,$dialogs,
					ReceiverListFactory) {

				$scope.title = "Buat Baru Receiver Member";
				$scope.isEdit = false;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				$scope.receiver = {
			
				};
				$scope.save = function() {
					ReceiverListFactory.create({
						receiver : $scope.receiver
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/receiver');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/receiver');
				};

			} ]);
        
        app.controller('ReceiverEditController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'ReceiverEditFactory',
			'ReceiverListFactory',
			function($scope, $routeParams, $location, $dialogs,ReceiverEditFactory,
					ReceiverListFactory) {

				$scope.title = "Ubah Data Member Receiver";
				$scope.isEdit = true;
                                
//                                $scope.genderList = [
//                                        {"name":"Pria"},
//                                        {"name":"Wanita"},
//                                ];

				ReceiverEditFactory.show({
					id : $routeParams.id
				}, function(data) {
					$scope.receiver = data.receiver;
				});

				$scope.save = function() {
					ReceiverEditFactory.update({
						id : $scope.receiver.id_receiver313339,
						receiver : $scope.receiver
					}, function(data) {
						notif($dialogs, data.status, 'Simpan');
						$location.path('/master/receiver');
					});

				};

				$scope.cancel = function() {
					$location.path('/master/receiver');
				};

			} ]);
        
        app.controller('ReceiverDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'ReceiverEditFactory',
	'ReceiverListFactory',
	function($scope, $routeParams, $location, ReceiverEditFactory,
			ReceiverListFactory) {

		$scope.title = "Info Detail Receiver (Member Penerima)";

		ReceiverEditFactory.show({
			id : $routeParams.id
		}, function(data) {
			$scope.receiver = data.receiver;
		});


		$scope.cancel = function() {
			$location.path('/master/receiver');
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

