package shougang.guigang.safety.rest.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import shougang.guigang.safety.mapper.TbJointinspectionMapper;
import shougang.guigang.safety.pojo.TbJointinspection;
import shougang.guigang.safety.pojo.TbJointinspectionExample;
import shougang.guigang.safety.pojo.TbJointinspectionExample.Criteria;
import shougang.guigang.safety.rest.service.JointInspectionService;
import shougang.guigang.sanzuoyequ.common.pojo.EasyUIDataGridResult;

/**
 * jonit inspection detailed item list rest service
 * @author admin
 *
 */
@Service
public class jointInspectionServiceImpl implements JointInspectionService {

	@Autowired
	private TbJointinspectionMapper jointinspectionMapper;
	
	@Override
	public EasyUIDataGridResult getInspectionItemDetailedList() {
		TbJointinspectionExample example = new TbJointinspectionExample();
		PageHelper.startPage(1, 10);
		List<TbJointinspection> list = jointinspectionMapper.selectByExampleWithBLOBs(example);
		PageInfo<TbJointinspection> pageInfo = new PageInfo<TbJointinspection>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}
	
	@Override
	public EasyUIDataGridResult searchInspectionList(Date StartInspectionDate, Date endInspectionDate,
			String inspectionSet, String inspectionResult, String inspectionDuty) throws ParseException {
		TbJointinspectionExample example = new TbJointinspectionExample();
		Criteria criteria = example.createCriteria();
		String dateStr = "2018-04-01";
		Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(dateStr);
		if (StartInspectionDate == null) {
			StartInspectionDate = date;
		}
		
		if (endInspectionDate == null) {
			endInspectionDate = new Date(System.currentTimeMillis());
		}
		
		criteria.andInspectionDateBetween(StartInspectionDate, endInspectionDate).andInspectionConditionEqualTo(inspectionSet , inspectionResult , inspectionDuty);
		
		PageHelper.startPage(1, 10);
		List<TbJointinspection> list = jointinspectionMapper.selectByExampleWithBLOBs(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		PageInfo<TbJointinspection> pageInfo = new PageInfo<TbJointinspection>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
