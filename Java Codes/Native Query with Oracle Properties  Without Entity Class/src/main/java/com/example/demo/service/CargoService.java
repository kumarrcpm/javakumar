package com.example.demo.service;

import com.example.demo.req.CargoReq;
import com.example.demo.res.CargoVisionRes;

public interface CargoService {

	CargoVisionRes getCargo(CargoReq req);

}
