/**
 * 
 */
package com.huawei.service;

import java.util.List;

import com.huawei.model.BrandInfo;

/** @author create by urmagical
*   @date   2018年3月18日 下午8:52:26
*   @version 
*/
public interface IBrandInfoService {


	/**
	 * @param id
	 * @return
	 */
	BrandInfo getBrandInfoById(Integer id);

	/**
	 * @return
	 */
	List<BrandInfo> getAll();

	/**
	 * @param brandInfo
	 * @return
	 */
	int addBrandInfo(BrandInfo brandInfo);

	/**
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);

	/**
	 * @param brandName
	 * @return
	 */
	List<BrandInfo> getBrandInfoByName(String brandName);


	/**
	 * @param ids
	 * @return 
	 */
	int deleteBatchByIds(Integer[] ids);

	/**
	 * @param brandInfo
	 * @return
	 */
	int updateBrandInfo(BrandInfo brandInfo);

}

