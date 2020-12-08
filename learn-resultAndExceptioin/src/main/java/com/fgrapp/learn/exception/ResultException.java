package com.fgrapp.learn.exception;

import com.fgrapp.learn.util.ResultStatus;
import lombok.Getter;

/**
 * ResultException
 *
 * @author fan guang rui
 * @date 2020年12月08日 15:41
 */
@Getter
public class ResultException extends Exception {

    /**
     * 业务异常信息信息
     */
    ResultStatus resultStatus;

    public ResultException() {
        this(ResultStatus.INTERNAL_SERVER_ERROR);
    }

    public ResultException(ResultStatus resultStatus) {
        super(resultStatus.getMessage());
        this.resultStatus = resultStatus;
    }
}
