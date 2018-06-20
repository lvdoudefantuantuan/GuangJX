package org.kzcw.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.kzcw.common.Iot.youren.YourenManager;
import org.kzcw.model.Lightbox;
import org.kzcw.model.User;
import org.kzcw.service.LightboxService;
import org.kzcw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {


	@Autowired
	UserService lservice;
	
    @RequestMapping("/index")
    public String index(ModelMap model,HttpServletRequest request){
    	
    	Lightbox lightbox=new Lightbox();
    	lightbox.setLOCATION("1234,21");
    	lightbox.setLOCKID(11);
    	lightbox.setMADEADDRESS("test");
    	lightbox.setSPEC("tt");
    	
    	User user=new User();
    	user.setNAME("test");
    	user.setPASSWD("ttt");
    	user.setSTATUS(1);
    	try {
    		lservice.save(user);
    		model.addAttribute("info","ok");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("info",e.getStackTrace().toString());
		}
    	
        return "demo";
    }
    
    @RequestMapping("/list")
    public String get(ModelMap model,HttpServletRequest request){
    	
    	model.addAttribute("info",lservice.list().size());
    	
        return "demo";
    }
    
    
	@RequestMapping("/unitaccrual")
	public String unitaccrual(ModelMap model,HttpServletRequest request){
		//**单位结息*/
		return "demo";
	}
	

	//***********************对账单与利息单———图表处理**********************************/
	
	@RequestMapping(value = "/uaccrualform", method = RequestMethod.GET)
	public String uaccrualform(ModelMap map,@RequestParam String FName,@RequestParam int FItemID,@RequestParam String starttime,@RequestParam String endtime,HttpServletRequest request)
			throws Exception {
		map.put("FName", FName);
		map.put("FNumber", FItemID);
		map.put("start", starttime);
		map.put("end", endtime);
		//map.put("heknotlist", scIntDpstService.findScIntDpst(FItemID, starttime, endtime));
		return "demo";
	}
    
	@RequestMapping("/openlock")
	@ResponseBody
	public Map<String,Object> GetCustomerNo(HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
	       new Thread("线程1"){
	            @Override
	            public void run(){
	        		YourenManager manager=new YourenManager();
	        		manager.OpenLock();
	            }
	        }.start();
		result.put("test","ok");
		return result;
	}
}

