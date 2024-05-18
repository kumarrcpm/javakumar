package controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import req.PremiumCalculationReq;
import res.CommonCrmRes;
import res.PremiumCalculationRes;

public class PremiumCalculationController {

	
//////Premium Calculation

@PostMapping(value = "/master/save/insurancepolicy")
public ResponseEntity<CommonCrmRes> premiumPolicy(@RequestBody PremiumCalculationReq req) {
reqPrinter.reqPrint(req);
CommonCrmRes data = new CommonCrmRes();
List<Error> validation = entityService.validatePremiumCalculation(req);
////validation
if (validation != null && validation.size() != 0) {
data.setCommonResponse(null);
data.setIsError(true);
data.setErrorMessage(validation);
data.setMessage("Failed");
return new ResponseEntity<CommonCrmRes>(data, HttpStatus.OK);

} else {
/////// save

PremiumCalculationRes res = entityService.savePremiumCalculation(req);
data.setCommonResponse(res);
data.setIsError(false);
data.setErrorMessage(Collections.emptyList());
data.setMessage("Success");
if (res != null) {
return new ResponseEntity<CommonCrmRes>(data, HttpStatus.CREATED);
} else {
return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
}
}

}
}


