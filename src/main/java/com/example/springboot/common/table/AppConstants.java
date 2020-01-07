package com.example.springboot.common.table;

/**
 * @Description: 微服务常量
 * @Author: xiaoliang.chen
 * @Date: 2019/2/21 下午3:33
 */
public interface AppConstants {

    String SERVICE_NAME = "hydra-code-download";

    String VERSION = "v1";

    String PATH = SERVICE_NAME + "/" + "api" + "/" + VERSION + "/";
    /**
     * redis中使用的key前缀（不用的微服务请保持不同，建议使用微服务名）
     */
    String REDIS_PREFIX = "hydra:code:download";

    String FIELD_PREFIX = "t_";

    String COLUMN_ID = "id";

    String COLUMN_CREATETIME = "create_time";

    String COLUMN_UPDATETIME = "update_time";

    String COLUMN_CODE_SYSTEM_ID = "code_system_id";

    String COLUMN_CODE_DOWNLOAD_ID = "code_system_id";

    String COLUMN_DATA_SOURCE_ID = "data_source_id";


    String DS_PREFIX = "hydra-code-pool-";

    Integer DS_SHARDING_NUMBER = 16;

    Integer TABLE_CODE_FOR_LENGTH_SHARDING_NUMBER = 1024;

    Integer TABLE_CODE_FOR_SYSTEM_SHARDING_NUMBER = 1024;

    String TABLE_CODE_FOR_LENGTH_PREFIX = "t_code_for_length_";

    String TABLE_CODE_FOR_SYSTEM_PREFIX = "t_code_for_system_";

    // 每次下载最大下载码数量
    Integer PER_DOWNLOAD_MAX_DOWNLOAD_QUANTITY = 100000;

    // 每次下载最大分表数量
    Integer PER_DOWNLOAD_MAX_SHARDING_TABLE_QUANTITY = 100;

    // 每个分表最大下载数量
    Integer PER_TABLE_MAX_DOWNLOAD_QUANTITY = 1000;

    // 每个分表最小下载数量
    Integer PER_TABLE_MIN_DOWNLOAD_QUANTITY = 500;

    // 分表下载码数量
    Integer SHARDING_TABLE_DOWNLOAD_QUANTITY = 100;

    //线程生码数量
    Integer THREAD_CREATE_CODE_QUANTITY = 1000;

    Integer MIN_THREAD_QUANTITY = 100;

    Integer MAX_THREAD_QUANTITY = 100;

    /*select * from information_schema.tables where table_name like "t_code_for_length_20_%" and table_rows>0;

    select * from information_schema.tables where table_name like "t_code_for_system_10_%" and table_rows>0;*/

}
