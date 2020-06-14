/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

	var services = angular.module('je-master-sender-service', [ 'ngResource' ]);

	
	services.factory('SenderListFactory', [ '$resource', function($resource) {

		return $resource('service/master/sender', {}, {
			query : {
				method : 'GET',
				isArray : false
			},
			create : {
				method : 'POST'
			}
		});

	} ]);
	
	services.factory('SenderEditFactory', [ '$resource', function($resource) {

		return $resource('service/master/sender/:id', {}, {
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


