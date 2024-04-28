package org.sealord.common.pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一返回结果
 * @author liu xw
 * @date 2024 04-11
 */
@Data
@RequiredArgsConstructor
public class Result<R> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 空成功返回
     */
    public static final Result<Void> SUC_EMPTY = toResult(HttpStatus.OK, null);

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 消息
     */
    private final String msg;


    /**
     * 返回结果值
     */
    private R data;

    /**
     * 请求正常返回
     * @param data 返回数据
     * @return 结束值
     * @param <R> 类型
     */
    public static <R> Result<R> success(R data) {
        return toResult(HttpStatus.OK, data);
    }

    /**
     * 构造
     * @param hs http的状态使用 spring提供的状态组件信息
     *           {@link HttpStatus}
     * @param data 返回结果
     * @return 结果值
     * @param <R> 类型
     */
    public static <R> Result<R> toResult(HttpStatus hs, R data) {
        return toResult(hs.value(), hs.getReasonPhrase(), data);
    }

    /**
     * 构造
     * @param code 错误编码
     * @param message 错误信息
     * @param data 返回结果
     * @return 结果值
     * @param <R> 类型
     */
    public static <R> Result<R> toResult(Integer code, String message, R data) {
        Result<R> r = new Result<>(code, message);
        r.setData(data);
        return r;
    }
}