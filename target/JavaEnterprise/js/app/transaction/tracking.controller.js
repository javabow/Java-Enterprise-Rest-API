/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var app = angular.module('je-transaction-tracking-controller', [
			'je-transaction-tracking-service',
                        'je-master-sender-service',
                        'je-master-receiver-service',
                        'je-master-track-service',
			'ui.bootstrap', 'dialogs' ]);

	app.controller('TrackingListController', [ '$scope', '$location',
			'$dialogs', 'TrackingListFactory',
			function($scope, $location, $dialogs, TrackingListFactory) {

				$scope.currentPage = 1;
				$scope.totalTracking = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = TrackingListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.trackingList = data.list;
						$scope.totalTracking = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/transaction/tracking/new');
				};
			
		        
			    $scope.edit = function (tracking) {
		            $location.path('/transaction/tracking/' + tracking.id_tracking313339 + '/edit');
                            };
		        
                            $scope.detail = function (tracking) {
                                $location.path('/transaction/tracking/' + tracking.id_tracking313339 + '/detail');
                            };

			} ]);

	app.controller('TrackingCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'TrackingListFactory',
                        'ReceiverListFactory',
                        'SenderListFactory',
			function($scope, $routeParams, $location,$dialogs,TrackingListFactory,ReceiverListFactory,SenderListFactory) {

				$scope.title = "Buat Baru Tracking";
				$scope.isEdit = false;
                                
                                $scope.statusList = [
                                        {"name":"Active"},
                                        {"name":"In Active"}
                                ];
                                
                                ReceiverListFactory.query({},function(data) {
                                                    $scope.receiverList = data.list;
                                            });
                                SenderListFactory.query({},function(data) {
                                                    $scope.senderList = data.list;
                                            });
		    			

				$scope.tracking = {
                                        
				};
                                
                                
                                 
				$scope.save = function() {
					TrackingListFactory.create({
						tracking : $scope.tracking
					}, function(data) {
						//notif($dialogs, data.status, 'Simpan');
                                                if(data.status == "OK"){
                                                    dlg = $dialogs.notify('Informasi', 'Data Sukses Disimpan');
                                                }else{
                                                    dlg = $dialogs.error('Data Gagal Disimpan :'+data.status);
                                                }
						$location.path('/transaction/tracking');
					});

				};

				$scope.cancel = function() {
					$location.path('/transaction/tracking');
				};

			} ]);
	
        app.controller('TrackingDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'TrackingEditFactory',
	function($scope, $routeParams, $location, TrackingEditFactory) {

		$scope.title = "Info Detail Tracking";

		TrackingEditFactory.show({
			id : $routeParams.id
		}, function(data) {
			$scope.tracking = data.tracking;
		});


		$scope.cancel = function() {
			$location.path('/transaction/tracking');
		};

	} ]);
	
	app.controller('TrackingEditController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'TrackingEditFactory',
			'ReceiverListFactory',
                        'SenderListFactory',
			function($scope, $routeParams, $location, $dialogs,TrackingEditFactory,
					ReceiverListFactory,SenderListFactory) {

				$scope.title = "Edit Data Tracking";
				$scope.isEdit = true;
                                
                                $scope.statusList = [
                                        {"name":"Active"},
                                        {"name":"In Active"}
                                ];
                                
                                ReceiverListFactory.query({},function(data) {
                                                    $scope.receiverList = data.list;
                                            });
                                SenderListFactory.query({},function(data) {
                                                    $scope.senderList = data.list;
                                            });
                                

				TrackingEditFactory.show({
					id : $routeParams.id
				}, function(data) {
					$scope.tracking = data.tracking;
				});

				$scope.save = function() {
					TrackingEditFactory.update({
						id : $scope.tracking.id_tracking313339,
						tracking : $scope.tracking
					}, function(data) {
						 if(data.status == "OK"){
                                                    dlg = $dialogs.notify('Informasi', 'Data Sukses Disimpan');
                                                }else{
                                                    dlg = $dialogs.error('Data Gagal Disimpan :'+data.status);
                                                }
						$location.path('/transaction/tracking');
					});

				};

				$scope.cancel = function() {
					$location.path('/transaction/tracking');
				};

			} ]);
	
	

	
	
	
	
})();

