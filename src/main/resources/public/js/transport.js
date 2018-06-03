var app = angular.module("demo", []);

app.controller("TransportCtrl", function($scope, $http){
    var transportId;

    $scope.transport = [];
    var time = performance.now();
    $http.get('/api/transport/showall').then(function(response){
        time = performance.now() - time;
        window.alert("Виведення відбулося за " + time + " мс.");
        $scope.transport = response.data;
    });

    this.createTransport = function createTransport(){
        var name = document.getElementById('transportName').value;
        var capacity = document.getElementById('transportCapacity').value;
        var seats = document.getElementById('fightingSeats').value;
        var type = document.getElementById('transportType').value;

        var request = {
            method: 'PUT',
            url : '/api/transport/insert',
            data: {
                name : name,
                capacity : capacity,
                fightingSeats : seats,
                transportType : type
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Створення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.startUpdate = function startUpdate(id, name, capacity, seats, type){
        transportId = id;
        document.getElementById('updateTransportName').value = name;
        document.getElementById('updateTransportCapacity').value = capacity;
        document.getElementById('updateTransportFightingSeats').value = seats;
        document.getElementById('updateTransportType').value = type;
    };

    this.update = function update(){
        var transportName = document.getElementById('updateTransportName').value;
        var transportCapacity = document.getElementById('updateTransportCapacity').value;
        var transportSeats = document.getElementById('updateTransportFightingSeats').value;
        var transportType = document.getElementById('updateTransportType').value;

        var request = {
            method: 'POST',
            url: '/api/transport/update?id=' + transportId,
            data: {
                name : transportName,
                capacity : transportCapacity,
                fightingSeats : transportSeats,
                transportType : transportType
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Оновлення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.del = function del(transportId){
        var time = performance.now();
        $http.post('/api/transport/delete?id=' + transportId).then(function(response){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            window.location.reload();
        });
    }
});



