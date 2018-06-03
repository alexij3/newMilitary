var app = angular.module("demo", []);

app.controller("PlatoonCtrl", function($scope, $http){
    var idToUpdate;

    $http.get('/api/squadron/showall').then(function(response) {
        console.log(response);
        var squadrons = response.data;
        var select = document.getElementById('selectSquadron');
        var selectSquadronUpd = document.getElementById('updateSelectSquadron');

        for (var i = 0; i < squadrons.length; i++) {
            var option = document.createElement("option");
            option.text = squadrons[i].name;
            option.value = squadrons[i].id;

            select.add(option);

            console.log(select);
        }

        for (var j = 0; j < squadrons.length; j++){
            var option2 = document.createElement("option");
            option2.text = squadrons[j].name;
            option2.value = squadrons[j].id;

            selectSquadronUpd.add(option2);
            console.log(selectSquadronUpd);
        }


    });

    var time = performance.now();
    $scope.platoon = [];
     $http.get('/api/platoon/showall').then(function (response){
         time = performance.now() - time;
         window.alert("Виведення відбулося за " + time + " мс.");
        $scope.platoon=response.data;
        console.log(response);
    });

    this.deletePlatoon = function deletePlatoon(id){
        var time = performance.now();
        $http.get('/api/platoon/delete?id=' + id).then(function(response){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();

        });
    };

    this.startCreatePlatoon = function startCreatePlatoon(){

    };

    this.createPlatoon = function createPlatoon(){
        var squadronId = document.getElementById('selectSquadron').value;
        var name = document.getElementById('platoonName').value;
        var code = document.getElementById('platoonCode').value;

        var request = {
            method: 'PUT',
            url: '/api/platoon/create?squadronId=' + squadronId,
            data: {
                name : name,
                codeNumber: code
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Створення відбулося за " + time + " мс.");
            console.log(response);
        });

        window.location.reload();
    };

    this.startUpdatePlatoon = function startUpdatePlatoon(id, name, code, squadronId) {
        idToUpdate = id;
        document.getElementById('updatePlatoonName').value = name;
        document.getElementById('updatePlatoonCode').value = code;
        document.getElementById('updateSelectSquadron').value = squadronId;

    };

    this.updatePlatoon = function updatePlatoon(){
        var name = document.getElementById('updatePlatoonName').value;
        var code = document.getElementById('updatePlatoonCode').value;
        var squadronId = document.getElementById('updateSelectSquadron').value;

        var request = {
            method: 'POST',
            url : '/api/platoon/update?squadronId=' + squadronId + '&id=' + idToUpdate,
            data: {
                name : name,
                codeNumber : code
            }
        };

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            window.alert("Оновлення відбулося за " + time + " мс.");
            console.log(response);
        });

        window.location.reload();
    }
});



