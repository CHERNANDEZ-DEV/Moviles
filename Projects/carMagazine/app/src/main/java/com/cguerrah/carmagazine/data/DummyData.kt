package com.cguerrah.carmagazine.data

import com.cguerrah.carmagazine.data.model.ServiceModel

var date = "12/08/2020"
var mechanic = "Juan Ortega"
var currentMileague = "50890"
var expectedMileague = "78965"

var services = mutableListOf(
    ServiceModel(date, mechanic, currentMileague, expectedMileague)
)