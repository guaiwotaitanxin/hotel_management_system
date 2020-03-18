package com.hyl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyl.common.R;
import com.hyl.entity.User;
import com.hyl.entity.query.QueryUser;
import com.hyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *   用户控制器层
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //1.查询所有用户
    @GetMapping
    public R getAllUserList(){
        //调用service方法
        List<User> list = userService.list(null);

        return R.ok().data("items",list);
    }

    // 2.逻辑删除用户
    @DeleteMapping("{id}")
    public R deleteUserById(@PathVariable Long id){
        boolean flag = userService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
    // 3. 分页查询
    @GetMapping("pageList/{page}/{limit}")
    public R getPageUserList(@PathVariable Long page,
                             @PathVariable Long limit){
        //创建page对象，传递两个参数
        Page<User> userpage = new Page<>(page,limit);
        //调用方法分页查询
        userService.page(userpage,null);
        //从userpage 对象里面获取分页数据
        long total = userpage.getTotal();
        List<User> records = userpage.getRecords();
        return R.ok().data("total",total).data("items",records);
    }

    // 4. 多条件组合查询带分页
        /** 获取json数据需要用到 @RequestBody
         *  但是使用@GetMapping提交得不到数据，所以只能用post
         * */
    @PostMapping("moreCondtionPageList/{page}/{limit}")
    public R getMoreCondtionPageList(@PathVariable Long page,
                                     @PathVariable Long limit,
                                     @RequestBody(required = false) QueryUser queryUser){
        Page<User> userpage = new Page<>(page,limit);
        //调用service的方法实现条件查询带分页
        userService.pageListCondtion(userpage,queryUser);
        //从userpage 对象里面获取分页数据
        long total = userpage.getTotal();
        List<User> records = userpage.getRecords();
        return R.ok().data("total",total).data("items",records);
    }

    // 5.添加用户
    @PostMapping("addUser")
    public R addUser(@RequestBody User user){
        boolean save = userService.save(user);
        if (save) {
            return R.ok();
        }else {
            return R.error();
        }
    }
    // 6. 根据id查询user
    @GetMapping("getUserInfo/{id}")
    public R getUserInfo(@PathVariable Long id){
        User user = userService.getById(id);
        return R.ok().data("user",user);
    }
    // 7.根据id修改
    @PostMapping("updateUser/{id}")
    public R updateUser(@PathVariable Long id,
                        @RequestBody User user){
        boolean b = userService.updateById(user);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }



























    /*//获取登录验证验证码
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpSession session){
        //获取5位长度的验证码
        String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
        //将验证码放入到session容器中（可以不区分大小写，存时全部转为小写）
        session.setAttribute("verifyCode",verifyCode.toLowerCase());
        try {
            //将生成的验证码响应显示到页面中
            VerifyCodeUtils.outputImage(250,35,response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //验证用户输入验证码是否正确
    @RequestMapping("/yzVerifyCode")
    public @ResponseBody String yzVerifyCode(String verifyCode, HttpSession session){
        //得到用户输入之前的显示的验证码与用户输入的验证码进行比较
        if(verifyCode.toLowerCase().equals(session.getAttribute("verifyCode"))){
            return "success";
        }else {
            return "fail";
        }
    }

    //用户登录
    @RequestMapping("/login")
    public @ResponseBody String login(User user, HttpSession session){
        //将用户输入的密码进行加密（去登录）
        user.setPwd(MD5.md5crypt(user.getPwd()));
        try {
            //根据用户名和密码进行登录
            User loginUser = baseService.findTByPramas(user);
            if(loginUser!=null){
                //登录成功将用户对象放入到session容器中
                session.setAttribute("loginUser",loginUser);
                return "success";
            }else {
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //用户退出
    @RequestMapping("/exitUser")
    public @ResponseBody String exitUser(HttpSession session){
        session.removeAttribute("loginUser");
        return "success";
    }*/

}
