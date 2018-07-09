/**
 * 
 */
package com.huawei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author create by urmagical
*   @date   2018年5月9日 下午11:34:17
*   @version 
*/
public class Te {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(format.format(new Date()));
	}
}

