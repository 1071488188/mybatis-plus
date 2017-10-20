package com.sourceprogram.util;

public class ErrorCode {

	public interface E00000000 {

		String CODE = "00000000";

		String MSG = "响应成功";
	}

	public interface E00000001 {

		String CODE = "00000001";

		String MSG = "服务器开小差了";
	}

	public interface E00000002 {

		String CODE = "00000002";

		String MSG = "响应失败";
	}

	public interface E00000003 {

		String CODE = "00000003";

		String MSG = "用户未登录";
	}

	public interface E00000004 {

		String CODE = "00000004";

		String MSG = "登录超时";
	}

	public interface E00000005 {

		String CODE = "00000005";

		String MSG = "数据解析异常";
	}

	public interface E00000006 {

		String CODE = "00000006";

		String MSG = "用户未授权";
	}


}
