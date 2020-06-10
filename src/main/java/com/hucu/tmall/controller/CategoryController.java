package com.hucu.tmall.controller;

import com.hucu.tmall.domain.Category;
import com.hucu.tmall.service.CategoryService;
import com.hucu.tmall.util.ImageUtil;
import com.hucu.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 后台页面：商品分类
 * 业务逻辑上就调用 CategoryService 的新list方法了
 * 然后返回的是 Page4Navigator 类型，并通过 RestController 转换为 json 对象抛给浏览器。
 *
 * @Author zhaoyulin
 */
@RestController
public class CategoryController {
	@Autowired CategoryService categoryService;

	/**
	 * 分页！！！！----学习代码！！！！
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/categories")
	public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		start = start<0?0:start;
		Page4Navigator<Category> page =categoryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
		return page;
	}

	/**
	 * 1. 通过CategoryService 保存到数据库
	 * 2. 然后接受上传图片，并保存到 img/category目录下
	 * 3. 文件名使用新增分类的id
	 * 4. 如果目录不存在，需要创建
	 * 5. image.transferTo 进行文件复制
	 * 6. 调用ImageUtil的change2jpg 进行文件类型强制转换为 jpg格式
	 * 7. 保存图片
	 * @param bean
	 * @param image
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/categories")
	public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
		categoryService.add(bean);
		saveOrUpdateImageFile(bean, image, request);
		return bean;
	}
	public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request)
			throws IOException {
		File imageFolder= new File(request.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder,bean.getId()+".jpg");
		if(!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		image.transferTo(file);
		BufferedImage img = ImageUtil.change2jpg(file);
		ImageIO.write(img, "jpg", file);
	}

	/**
	 * 映射 ListCategory.html的 ajax 请求
	 * 1. 首先根据id 删除数据库里的数据
	 * 2. 删除对应的文件
	 * 3. 返回 null, 会被RESTController 转换为空字符串。
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/categories/{id}")
	public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
		categoryService.delete(id);
		File  imageFolder= new File(request.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder,id+".jpg");
		file.delete();
		return null;
	}

	/**
	 * 提供get方法，把id对应的Category取出来，并转换为json对象发给浏览器
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/categories/{id}")
	public Category get(@PathVariable("id") int id) throws Exception {
		Category bean=categoryService.get(id);
		return bean;
	}

	/**
	 * 通过CategoryService的update方法更新到数据库
	 * @param bean
	 * @param image
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/categories/{id}")
	public Object update(Category bean, MultipartFile image,HttpServletRequest request) throws Exception {
		String name = request.getParameter("name");
		bean.setName(name);
		categoryService.update(bean);

		if(image!=null) {
			saveOrUpdateImageFile(bean, image, request);
		}
		return bean;
	}

}



