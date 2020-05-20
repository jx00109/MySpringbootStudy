package com.ytj.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: MySpringbootStudy
 * @description: 控制器
 * @author: admin
 * @create: 2020-04-24 15:02
 **/
@RequestMapping("/api/excel")
@RestController
@Slf4j
public class ExcelController {

    @GetMapping("/getUserInObj")
    public RespDetails getUserInObj() {
        return new RespDetails(1, generateUsers(10), "直接返回对象");
    }

    @GetMapping("/getUserInJson")
    public String getUserInJson() {
        return JSON.toJSONString(new RespDetails(1, generateUsers(10), "直接返回对象"));
    }

    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     *
     * @since 2.1.1
     */
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("模板", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            Set<String> colNames = new HashSet<>();
            colNames.add("password");

            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), User.class)
                    .autoCloseStream(Boolean.FALSE)
                    .excludeColumnFiledNames(colNames)
                    .sheet("模板数据")
                    .doWrite(generateUsers(10));
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            JSONObject json = new JSONObject();
            json.put("status", 0);
            json.put("msg", "下载文件失败" + e.getMessage());
            response.getWriter().println(json.toJSONString());
        }

    }

    /**
     * 文件上传
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link User}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link User}
     * <p>
     * 3. 直接读即可
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), User.class, new UserDataListener()).sheet().doRead();
        JSONObject json = new JSONObject();
        json.put("status", 1);
        json.put("msg", "上传成功");
        return JSON.toJSONString(json);
    }

    private List<User> generateUsers(int n) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setUsername(String.format("USER %d", i + 1));
            user.setPassword("111111");
            user.setName("user" + i);
            user.setContactNumber("123456");
            user.setDepartment(String.format("第%d所", i + 1));
            user.setTownName(String.format("乡镇%d", i + 1));
            user.setTownCode(String.format("乡镇代码%d", i + 1));

            list.add(user);
        }
        return list;
    }
}
