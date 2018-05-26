package shougang.guigang.safety.rest.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shougang.guigang.safety.rest.service.JointInspectionService;
import shougang.guigang.sanzuoyequ.common.pojo.EasyUIDataGridResult;

/**
 * joint inspection detailed item list rest controller
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/inspection")
public class JointInspectionController {

	@Autowired
	private JointInspectionService jointInspectionService;

	@RequestMapping("/inspectionList")
	@ResponseBody
	private EasyUIDataGridResult getInspectionItemDetailedList() {
		EasyUIDataGridResult dataGridResult = jointInspectionService.getInspectionItemDetailedList();
		return dataGridResult;
	}

	@RequestMapping(value = "/inspectionSearch", method = RequestMethod.POST)
	@ResponseBody
	private EasyUIDataGridResult searchInspectionList(Date StartInspectionDate, Date endInspectionDate,
			String inspectionSet, String inspectionResult, String inspectionDuty)
			throws ParseException {
		EasyUIDataGridResult result = jointInspectionService.searchInspectionList(StartInspectionDate,
				endInspectionDate, inspectionSet, inspectionResult, inspectionDuty);
		return result;
	}
}
