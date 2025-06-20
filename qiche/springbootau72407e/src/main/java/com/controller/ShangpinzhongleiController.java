package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShangpinzhongleiEntity;
import com.entity.view.ShangpinzhongleiView;

import com.service.ShangpinzhongleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 汽车种类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-12 13:37:41
 */
@RestController
@RequestMapping("/shangpinzhonglei")
public class ShangpinzhongleiController {
    @Autowired
    private ShangpinzhongleiService shangpinzhongleiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinzhongleiEntity shangpinzhonglei,
		HttpServletRequest request){
        EntityWrapper<ShangpinzhongleiEntity> ew = new EntityWrapper<ShangpinzhongleiEntity>();

		PageUtils page = shangpinzhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinzhonglei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinzhongleiEntity shangpinzhonglei, 
		HttpServletRequest request){
        EntityWrapper<ShangpinzhongleiEntity> ew = new EntityWrapper<ShangpinzhongleiEntity>();

		PageUtils page = shangpinzhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinzhonglei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinzhongleiEntity shangpinzhonglei){
       	EntityWrapper<ShangpinzhongleiEntity> ew = new EntityWrapper<ShangpinzhongleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinzhonglei, "shangpinzhonglei")); 
        return R.ok().put("data", shangpinzhongleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinzhongleiEntity shangpinzhonglei){
        EntityWrapper< ShangpinzhongleiEntity> ew = new EntityWrapper< ShangpinzhongleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinzhonglei, "shangpinzhonglei")); 
		ShangpinzhongleiView shangpinzhongleiView =  shangpinzhongleiService.selectView(ew);
		return R.ok("查询汽车种类成功").put("data", shangpinzhongleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinzhongleiEntity shangpinzhonglei = shangpinzhongleiService.selectById(id);
        return R.ok().put("data", shangpinzhonglei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinzhongleiEntity shangpinzhonglei = shangpinzhongleiService.selectById(id);
        return R.ok().put("data", shangpinzhonglei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinzhongleiEntity shangpinzhonglei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shangpinzhonglei);
        shangpinzhongleiService.insert(shangpinzhonglei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinzhongleiEntity shangpinzhonglei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shangpinzhonglei);
        shangpinzhongleiService.insert(shangpinzhonglei);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShangpinzhongleiEntity shangpinzhonglei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinzhonglei);
        shangpinzhongleiService.updateById(shangpinzhonglei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinzhongleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
