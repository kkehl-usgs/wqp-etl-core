package gov.acwi.wqp.etl.projectObject;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.EtlConstantUtils;
import gov.acwi.wqp.etl.FunctionCallTasklet;

@Component
@StepScope
public class AnalyzeProjectObject extends FunctionCallTasklet {

	public static final String FUNCTION_NAME = "analyze_project_object";

	@Autowired
	public AnalyzeProjectObject(JdbcTemplate jdbcTemplate,
			@Value(EtlConstantUtils.VALUE_JOB_PARM_DATA_SOURCE) String wqpDataSource,
			@Value(EtlConstantUtils.VALUE_JOB_PARM_WQP_SCHEMA) String wqpSchemaName) {
		super(jdbcTemplate, wqpDataSource, wqpSchemaName);
	}

	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	protected String getBaseTableName() {
		return ProjectObject.BASE_TABLE_NAME;
	}
}
