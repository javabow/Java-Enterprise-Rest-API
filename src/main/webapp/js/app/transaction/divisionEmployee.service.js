(function() {

	var services = angular.module('je-transaksi-paket-service', [ 'ngResource' ]);

	
	services.factory('TrDivisionEmployeeListFactory', [ '$resource', function($resource) {

		return $resource('service/transaksi/paket', {}, {
			query : {
				method : 'GET',
				isArray : false
			},
			create : {
				method : 'POST'
			}
		});

	} ]);
	
	services.factory('TrDivisionEmployeeEditFactory', [ '$resource', function($resource) {

		return $resource('service/transaction/trDivisionEmployee/:id', {}, {
			show : {
				method : 'GET',
				params: {id: '@id'}
			}
//			update : {
//				method : 'PUT',
//				params :{id: '@id'}
//			}
		});

	} ]);
	
})();