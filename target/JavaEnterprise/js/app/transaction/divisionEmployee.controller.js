(function() {

	var app = angular.module('je-transaction-divisionEmployee-controller', [
			'je-transaction-divisionEmployee-service',
                        'je-master-division-service',
                        'je-master-employee-service',
			'ui.bootstrap', 'dialogs' ]);

	app.controller('TrDivisionEmployeeListController', [ '$scope', '$location',
			'$dialogs', 'TrDivisionEmployeeListFactory',
			function($scope, $location, $dialogs, TrDivisionEmployeeListFactory) {

				$scope.currentPage = 1;
				$scope.totalTrDivisionEmployee = 0;
				$scope.pageSize = 10;

				$scope.pagination = {
					current : 1
				};

				//ordering
				$scope.predicate='name';
                                $scope.reverse=false;
	            
				$scope.pageChanged = function(newPage) {
					$scope.gridPromise = TrDivisionEmployeeListFactory.query({
						activePage : newPage,
						order : $scope.predicate + "-" + ($scope.reverse ? "desc" : "asc")
					}, function(data) {
						$scope.trDivisionEmployeeList = data.list;
						$scope.totalTrDivisionEmployee = data.total;
					});
				};
				$scope.pageChanged(1);

				$scope.search = function() {
					$scope.currentPage = 1;
					$scope.pageChanged(1);
				};

				$scope.create = function() {
					$location.path('/transaction/divisionEmployee/new');
				};
			
		        
			    $scope.edit = function (trDivisionEmployee) {
		            $location.path('/transaction/divisionEmployee/' + trDivisionEmployee.id + '/edit');
                            };
		        
                            $scope.detail = function (trDivisionEmployee) {
                                $location.path('/transaction/divisionEmployee/' + trDivisionEmployee.id + '/detail');
                            };

			} ]);

	app.controller('TrDivisionEmployeeCreateController', [
			'$scope',
			'$routeParams',
			'$location',
			'$dialogs',
			'TrDivisionEmployeeListFactory',
                        'DivisionListFactory',
                        'EmployeeListFactory',
			function($scope, $routeParams, $location,$dialogs,TrDivisionEmployeeListFactory,DivisionListFactory,EmployeeListFactory) {

				$scope.title = "Buat Baru Karyawan-Divisi";
				$scope.isEdit = false;
                                
                                $scope.statusList = [
                                        {"name":"Active"},
                                        {"name":"In Active"}
                                ];
                                
                                DivisionListFactory.query({},function(data) {
                                                    $scope.divisionList = data.list;
                                            });
                                EmployeeListFactory.query({},function(data) {
                                                    $scope.employeeList = data.list;
                                            });
		    			

				$scope.trDivisionEmployee = {
                                        
				};
                                
                                
                                 
				$scope.save = function() {
					TrDivisionEmployeeListFactory.create({
						trDivisionEmployee : $scope.trDivisionEmployee
					}, function(data) {
						//notif($dialogs, data.status, 'Simpan');
                                                if(data.statusCode == "00"){
                                                    dlg = $dialogs.notify('Informasi', 'Data Sukses Disimpan');
                                                }else{
                                                    dlg = $dialogs.error('Data Gagal Disimpan :'+data.status);
                                                }
						$location.path('/transaction/divisionEmployee');
					});

				};

				$scope.cancel = function() {
					$location.path('/transaction/divisionEmployee');
				};

			} ]);
	
        app.controller('TrDivisionEmployeeDetailController', [
	'$scope',
	'$routeParams',
	'$location',
	'TrDivisionEmployeeEditFactory',
	function($scope, $routeParams, $location, TrDivisionEmployeeEditFactory) {

		$scope.title = "Info Detail Karyawan-Divisi";

		TrDivisionEmployeeEditFactory.show({
			id : $routeParams.id
		}, function(data) {
			$scope.trDivisionEmployee = data.trDivisionEmployee;
		});


		$scope.cancel = function() {
			$location.path('/transaction/divisionEmployee');
		};

	} ]);
	
//	app.controller('TrDivisionEmployeeEditController', [
//			'$scope',
//			'$routeParams',
//			'$location',
//			'$dialogs',
//			'TrDivisionEmployeeEditFactory',
//			'DivisionListFactory',
//                        'EmployeeListFactory',
//			function($scope, $routeParams, $location, $dialogs,TrDivisionEmployeeEditFactory,
//					DivisionListFactory,EmployeeListFactory) {
//
//				$scope.title = "Ubah Karyawan-Divisi";
//				$scope.isEdit = true;
//                                
//                                $scope.statusList = [
//                                        {"name":"Active"},
//                                        {"name":"In Active"}
//                                ];
//                                
//                                DivisionListFactory.query({},function(data) {
//                                                    $scope.divisionList = data.list;
//                                            });
//                                EmployeeListFactory.query({},function(data) {
//                                                    $scope.employeeList = data.list;
//                                            });
//                                
//
//				TrDivisionEmployeeEditFactory.show({
//					id : $routeParams.id
//				}, function(data) {
//					$scope.trDivisionEmployee = data.trDivisionEmployee;
//				});
//
//				$scope.save = function() {
//					TrDivisionEmployeeEditFactory.update({
//						id : $scope.trDivisionEmployee.id,
//						trDivisionEmployee : $scope.trDivisionEmployee
//					}, function(data) {
//						 if(data.statusCode == "00"){
//                                                    dlg = $dialogs.notify('Informasi', 'Data Sukses Disimpan');
//                                                }else{
//                                                    dlg = $dialogs.error('Data Gagal Disimpan :'+data.status);
//                                                }
//						$location.path('/transaction/divisionEmployee');
//					});
//
//				};
//
//				$scope.cancel = function() {
//					$location.path('/transaction/divisionEmployee');
//				};
//
//			} ]);
	
	

	
	
	
	
})();
