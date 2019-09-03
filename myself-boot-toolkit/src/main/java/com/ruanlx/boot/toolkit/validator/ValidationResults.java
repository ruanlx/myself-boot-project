package com.ruanlx.boot.toolkit.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * 校验工具类返回的数据ValidationResult
 *
 * @ClassName ValidationResult
 * @author ruanlx/无邪
 * @DateTime 2019-08-12 00:24
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public class ValidationResults {
    private boolean hasError;
    private Map<String, String> errorMap;
}