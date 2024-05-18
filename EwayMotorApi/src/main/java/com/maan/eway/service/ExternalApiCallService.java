package com.maan.eway.service;

import com.maan.eway.req.TiraMsg;
import com.maan.eway.req.push.TiraMsgVehiclePush;
import com.maan.eway.res.MotorTiraMsgRes;

public interface ExternalApiCallService {

	MotorTiraMsgRes getSampleData(TiraMsg req);

	void pushVehicleInfo(TiraMsgVehiclePush req);

}
