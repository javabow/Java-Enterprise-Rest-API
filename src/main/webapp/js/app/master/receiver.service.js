/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var services = angular.module('je-master-receiver-service', [ 'ngResource' ]);

	
	services.factory('ReceiverListFactory', [ '$resource', function($resource) {

		return $resource('service/master/receiver', {}, {
			query : {
				method : 'GET',
				isArray : false
			},
			create : {
				method : 'POST'
			}
		});

	} ]);
	
	services.factory('ReceiverEditFactory', [ '$resource', function($resource) {

		return $resource('service/master/receiver/:id', {}, {
			show : {
				method : 'GET',
				params: {id: '@id'}
			},
			update : {
				method : 'PUT',
				params :{id: '@id'}
			},
			remove : {
				method : 'DELETE',
				params :{id: '@id'}
			}
		});

	} ]);
	
})();


