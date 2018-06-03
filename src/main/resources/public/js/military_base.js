var app = angular.module("demo", []);

app.controller("MilitaryBaseCtrl", function($scope, $http){
    var idToUpdate;

    $scope.militaryBase = [];
    var time = performance.now();
    $http.get('/api/militarybase/showall').then(function(response){
        $scope.militaryBase = response.data;
        var local = [];
        local = $scope.militaryBase;

        var selectBase = document.getElementById('selectBaseQuery');


        for (var p = 0; p < local.length; p++){
            var option4 = document.createElement("option");
            option4.text = local[p].name;
            option4.value = local[p].id;

            selectBase.add(option4);
            console.log(selectBase);
        }

        time = performance.now() - time;

        window.alert("Виведення відбулося за " + time + " мс.");
        $http.get('/api/soldier/showall').then(function(response) {
            console.log(response);
            var captain = response.data;
            var select = document.getElementById('selectCaptain');
            var selectCaptainUpd = document.getElementById('updSelectCaptain');

            for (var i = 0; i < captain.length; i++) {
                var option = document.createElement("option");
                option.text = captain[i].name;
                option.value = captain[i].id;

                select.append(option);

                console.log(select);
            }

            for (var j = 0; j < captain.length; j++){
                var option2 = document.createElement("option");
                option2.text = captain[j].name;
                option2.value = captain[j].id;

                selectCaptainUpd.add(option2);
                console.log(selectCaptainUpd);
            }
        });
    });

    $http.get('/api/army/showall').then(function(response) {
        console.log(response);
        var armies = response.data;
        var select = document.getElementById('selectArmy');
        var selectArmyUpd = document.getElementById('updSelectArmy');
        var selectArmyQuery = document.getElementById('selectArmyQuery');


        for (var i = 0; i < armies.length; i++) {
            var option = document.createElement("option");
            option.text = armies[i].name;
            option.value = armies[i].id;

            select.add(option);

            console.log(select);
        }

        for (var j = 0; j < armies.length; j++){
            var option2 = document.createElement("option");
            option2.text = armies[j].name;
            option2.value = armies[j].id;

            selectArmyUpd.add(option2);
            console.log(selectArmyUpd);
        }

        for (var k = 0; k < armies.length; k++){
            var option3 = document.createElement("option");
            option3.text = armies[k].name;
            option3.value = armies[k].id;

            selectArmyQuery.add(option3);
            console.log(selectArmyQuery);
        }

    });

    $http.get('/api/division/showall').then(function(response) {
        console.log(response);
        var divisions = response.data;
        var select = document.getElementById('selectDivision');
        var selectDivisionUpd = document.getElementById('updSelectDivision');
        var selectDivisionQuery = document.getElementById('selectDivisionQuery');

        for (var i = 0; i < divisions.length; i++) {
            var option = document.createElement("option");
            option.text = divisions[i].name;
            option.value = divisions[i].id;

            select.append(option);

            console.log(select);
        }

        for (var j = 0; j < divisions.length; j++){
            var option2 = document.createElement("option");
            option2.text = divisions[j].name;
            option2.value = divisions[j].id;

            selectDivisionUpd.add(option2);
            console.log(selectDivisionUpd);
        }

        for (var k = 0; k < divisions.length; k++){
            var option3 = document.createElement("option");
            option3.text = divisions[k].name;
            option3.value = divisions[k].id;

            selectDivisionQuery.add(option3);
            console.log(selectDivisionQuery);
        }


    });

    $http.get('/api/corps/showall').then(function(response) {
        console.log(response);
        var corps = response.data;
        var select = document.getElementById('selectCorps');
        var selectCorpsUpd = document.getElementById('updSelectCorps');
        var selectCorpsQuery = document.getElementById('selectCorpsQuery');

        for (var i = 0; i < corps.length; i++) {
            var option = document.createElement("option");
            option.text = corps[i].name;
            option.value = corps[i].id;

            select.append(option);

            console.log(select);
        }

        for (var j = 0; j < corps.length; j++){
            var option2 = document.createElement("option");
            option2.text = corps[j].name;
            option2.value = corps[j].id;

            selectCorpsUpd.add(option2);
            console.log(selectCorpsUpd);
        }

        for (var k = 0; k < corps.length; k++){
            var option3 = document.createElement("option");
            option3.text = corps[k].name;
            option3.value = corps[k].id;

            selectCorpsQuery.add(option3);
            console.log(selectCorpsQuery);
        }

    });

    $http.get('/api/brigade/showall').then(function(response) {
        console.log(response);
        var brigade = response.data;
        var select = document.getElementById('selectBrigade');
        var selectBrigadeUpd = document.getElementById('updSelectBrigade');

        for (var i = 0; i < brigade.length; i++) {
            var option = document.createElement("option");
            option.text = brigade[i].name;
            option.value = brigade[i].id;

            select.append(option);

            console.log(select);
        }

        for (var j = 0; j < brigade.length; j++){
            var option2 = document.createElement("option");
            option2.text = brigade[j].name;
            option2.value = brigade[j].id;

            selectBrigadeUpd.add(option2);
            console.log(selectBrigadeUpd);
        }
    });

    $http.get('/api/buildings/showall').then(function(response) {
        console.log(response);
        var buildings = response.data;
        var select = document.getElementById('selectDislocation');
        var selectBuildingsUpd = document.getElementById('updSelectDislocation');

        for (var i = 0; i < buildings.length; i++) {
            var option = document.createElement("option");
            option.text = buildings[i].name;
            option.value = buildings[i].id;

            select.add(option);

            console.log(select);
        }

        for (var j = 0; j < buildings.length; j++){
            var option2 = document.createElement("option");
            option2.text = buildings[j].name;
            option2.value = buildings[j].id;

            selectBuildingsUpd.add(option2);
            console.log(selectBuildingsUpd);
        }
    });



    this.createMilitaryBase = function createMilitaryBase(){
        var name = document.getElementById('militaryBaseName').value;
        var armyId = document.getElementById('selectArmy').value;
        var dislocationId = document.getElementById('selectDislocation').value;

        var divisionId;
        var corpsId;
        var brigadeId;

        if (document.getElementById('radioDivision').checked == true){
            window.alert("DIvision");
            divisionId = document.getElementById('selectDivision').value;
            corpsId = 0;
            brigadeId = 0;
        }else if (document.getElementById('radioCorps').checked == true){
            window.alert("Corps");
            corpsId = document.getElementById('selectCorps').value;
            window.alert(corpsId);
            divisionId = 0;
            brigadeId = 0;
        }else if (document.getElementById('radioBrigade').checked == true){
            window.alert("Brigade");
            brigadeId = document.getElementById('selectBrigade').value;
            corpsId = 0;
            divisionId = 0;
        }else{
            brigadeId = 0;
            corpsId = 0;
            divisionId = 0;
        }

        var captainId = document.getElementById('selectCaptain').value;
        if (captainId == "") captainId = 0;

        var request = {
            method: 'PUT',
            url: '/api/militarybase/create?armyId=' + armyId + '&divisionId=' + divisionId + '&corpsId=' + corpsId
                                                    + '&brigadeId=' + brigadeId + '&captainId=' + captainId + '&dislocationId=' + dislocationId,
            data : {
                name : name
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            console.log("Створення відбулося за " + time + " мс.");
            console.log(response);
        });

        window.location.reload();
    };

        this.startUpdate = function startUpdate(id, name, armyId, divisionId, corpsId, brigadeId, dislocationId, captainId){
            idToUpdate = id;
            document.getElementById('updMilitaryBaseName').value = name;
            document.getElementById('updSelectArmy').value = armyId;
            document.getElementById('updSelectDivision').value = divisionId;
            document.getElementById('updSelectCorps').value = corpsId;
            document.getElementById('updSelectBrigade').value = brigadeId;
            document.getElementById('updSelectDislocation').value = dislocationId;
            document.getElementById('updSelectCaptain').value = captainId;

        };

        this.update = function update(){
            var name = document.getElementById('updMilitaryBaseName').value;
            var armyId = document.getElementById('updSelectArmy').value;
            var dislocationId = document.getElementById('updSelectDislocation').value;

            var divisionId;
            var corpsId;
            var brigadeId;

            if (document.getElementById('updRadioDivision').checked == true){
                divisionId = document.getElementById('updSelectDivision').value;
                corpsId = 0;
                brigadeId = 0;
            }else if (document.getElementById('updRadioCorps').checked == true){
                corpsId = document.getElementById('updSelectCorps').value;
                divisionId = 0;
                brigadeId = 0;
            }else if (document.getElementById('updRadioBrigade').checked == true){
                brigadeId = document.getElementById('updSelectBrigade').value;
                corpsId = 0;
                divisionId = 0;
            }else{
                brigadeId = 0;
                corpsId = 0;
                divisionId = 0;
            }

            var captainId = document.getElementById('updSelectCaptain').value;
            if (captainId == "") captainId = 0;

            var request = {
                method: 'POST',
                url: '/api/militarybase/update?id=' + idToUpdate + '&armyId=' + armyId + '&divisionId=' + divisionId + '&corpsId=' + corpsId
                + '&brigadeId=' + brigadeId + '&captainId=' + captainId + '&dislocationId=' + dislocationId,
                data : {
                    name : name
                }
            };

            var time = performance.now();
            $http(request).then(function(response){
                time = performance.now() - time;
                console.log("Оновлення відбулося за " + time + " мс.");
                console.log(response);
            });

            window.location.reload();
        };

        this.del = function del(id){
            $http.post('/api/militarybase/delete?id=' + id);
            window.location.reload();
        };

        /**********
         * QUERIES
         *********/

        this.findByArmyId = function findByArmyId(){
            var id = $('#selectArmyQuery').val();

            $http.get('/api/militarybase/findAllByArmyId?id=' + id).then(function (response){
                $scope.militaryBase = response.data;
            });
        };

        this.findByDivisionId = function findByDivisionId(){
            var id = $('#selectDivisionQuery').val();

            $http.get('/api/militarybase/findAllByDivisionId?id=' + id).then(function (response){
                $scope.militaryBase = response.data;
            });
        };

        this.findByCorpsId = function findByCorpsId(){
            var id = $('#selectCorpsQuery').val();

            $http.get('/api/militarybase/findAllByCorpsId?id=' + id).then(function (response){
                $scope.militaryBase = response.data;
            });
        };

        this.findDislocationsById = function findDislocationsById(){
            var id = $('#selectBaseQuery').val();

            $http.get('/api/militarybase/get?id=' + id).then(function(response){
                $scope.militaryBase = response.data;
            });
        }
});



