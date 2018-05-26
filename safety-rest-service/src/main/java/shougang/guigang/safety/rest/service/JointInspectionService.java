package shougang.guigang.safety.rest.service;

import java.text.ParseException;
import java.util.Date;

import shougang.guigang.sanzuoyequ.common.pojo.EasyUIDataGridResult;

public interface JointInspectionService {
	EasyUIDataGridResult getInspectionItemDetailedList(/*Integer page , Integer rows*/);
	
	EasyUIDataGridResult searchInspectionList(Date StartInspectionDate , Date endInspectionDate 
			, String inspectionSet , String inspectionResult 
			, String inspectionDuty) throws ParseException;
}
