package com.ruanlx.boot.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 校验工具类返回的数据ValidationResult
 *
 * @ClassName ValidationResult
 * @author ruanlx
 * @DateTime 2019-08-12 00:24
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public class ValidationResult {
    private boolean hasError;
    private String message;
}