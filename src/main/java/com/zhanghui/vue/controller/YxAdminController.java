package com.zhanghui.vue.controller;

import com.zhanghui.vue.entity.YxAdmin;
import com.zhanghui.vue.service.YxAdminService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (YxAdmin)表控制层
 *
 * @author makejava
 * @since 2020-07-12 18:10:26
 */
@RestController
@RequestMapping("yxAdmin")
@Slf4j
public class YxAdminController {
    /**
     * 服务对象
     */
    @Resource
    private YxAdminService yxAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("findOneAdmin")
    public YxAdmin findOneAdmin(String id) {
        return this.yxAdminService.queryById(id);
    }

    @PostMapping("insert")
    public HashMap<String, String> insert(@RequestBody YxAdmin yxAdmin) {
        log.info("后台得到数据:{}", yxAdmin);
        HashMap<String, String> map = yxAdminService.insert(yxAdmin);
        return map;
    }


    @GetMapping("delById")
    public void delById(String id) {
        boolean b = yxAdminService.deleteById(id);
        System.out.println(b);
    }


    @CrossOrigin
    @GetMapping("selectAll")
    public List<YxAdmin> selectAll() {
        List<YxAdmin> yxAdmins = this.yxAdminService.queryAllByLimit(0, 10);
        return yxAdmins;
    }

    @GetMapping("queryWeatherByCity")
    public Map<String, String> queryWeatherByCity(String name) {
        HashMap<String, String> map = new HashMap<>();
        String s = queryByName(name);
        map.put("name", s);
        return map;
    }

    public String queryByName(String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("北京", "今天天气不错,大晴天噢");
        map.put("上海", "天气优，多云，当前气温34度");
        map.put("河北", "天气还好");
        map.put("河南", "今天天气不错,适合晒太阳");


        return map.get(name);
    }
}