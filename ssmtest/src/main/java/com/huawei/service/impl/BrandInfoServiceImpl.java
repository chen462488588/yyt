/**
 * 
 */
package com.huawei.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huawei.mapper.BrandInfoMapper;
import com.huawei.model.BrandInfo;
import com.huawei.model.BrandInfoExample;
import com.huawei.service.IBrandInfoService;

/**
 * @author create by urmagical
 * @date 2018年3月18日 下午8:52:45
 * @version
 */
@Service
@Transactional
public class BrandInfoServiceImpl implements IBrandInfoService {

	@Autowired
	private BrandInfoMapper mapper;

	/*********** getter and setter ****************/
	public BrandInfoMapper getMapper() {
		return mapper;
	}

	public void setMapper(BrandInfoMapper mapper) {
		this.mapper = mapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huawei.service.IBrandInfoService#getBrandInfoById(java.lang.Integer)
	 */
	@Override
	public BrandInfo getBrandInfoById(Integer id) {
		BrandInfo brandInfo = mapper.selectByPrimaryKey(id);
		return brandInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huawei.service.IBrandInfoService#getAll()
	 */
	@Override
	public List<BrandInfo> getAll() {
		BrandInfoExample example = new BrandInfoExample();
		example.createCriteria().andFlagEqualTo(true);
		return mapper.selectByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huawei.service.IBrandInfoService#addBrandInfo(com.huawei.model.BrandInfo)
	 */
	@Override
	public int addBrandInfo(BrandInfo brandInfo) {

		return mapper.insertSelective(brandInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huawei.service.IBrandInfoService#deleteById(java.lang.Integer)
	 */
	@Override
	public int deleteById(Integer id) {
		BrandInfoExample example = new BrandInfoExample();
		example.createCriteria().andIdEqualTo(id);
		List<BrandInfo> list = mapper.selectByExample(example);
		BrandInfo brandInfo = null;
		if (list != null && list.size() != 0) {
			brandInfo = list.get(0);
			brandInfo.setFlag(false);
		}

		return mapper.updateByExampleSelective(brandInfo, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huawei.service.IBrandInfoService#getBrandInfoByName(java.lang.String)
	 */
	@Override
	public List<BrandInfo> getBrandInfoByName(String brandName) {
		BrandInfoExample example = new BrandInfoExample();
		example.createCriteria().andBrandNameLike("%"+brandName+"%").andFlagEqualTo(true);
		List<BrandInfo> list = mapper.selectByExample(example);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huawei.service.IBrandInfoService#deleteBatchByIds(java.lang.Integer[])
	 */
	@Override
	public int deleteBatchByIds(Integer[] ids) {
		BrandInfoExample example = new BrandInfoExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));

		BrandInfo brandInfo = new BrandInfo();
		brandInfo.setFlag(false);

		return mapper.updateByExampleSelective(brandInfo, example);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huawei.service.IBrandInfoService#updateBrandInfo(com.huawei.model.
	 * BrandInfo)
	 */
	@Override
	public int updateBrandInfo(BrandInfo brandInfo) {
		int row = mapper.updateByPrimaryKeySelective(brandInfo);
		return row;
	}

}
