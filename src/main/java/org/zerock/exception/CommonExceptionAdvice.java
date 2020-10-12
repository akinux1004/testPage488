package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {

		log.error("Exception ......." + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {

		return "custom404";
	}
	
	// 적용 안되잖어 싀벌!!!
//	@ExceptionHandler(RuntimeException.class)
//	public ModelAndView viewRuntimeException(RuntimeException e) {
//		ModelAndView view = new ModelAndView();
//		
//		view.setViewName("/uploadAjax");
//		
//		if(e instanceof MaxUploadSizeExceededException) {
//			view.addObject("message", "업로드 가능한 용량을 초과 합니다.");
//		} else if(e instanceof IllegalStateException) {
//			view.addObject("message", "IllegalStateException");
//		} else if(e instanceof RuntimeException) {
//			view.addObject("message", "런타임 오류");
//		} else {
//			view.addObject("message", e.getMessage());
//		}
//		
//		return view;
//	}

}
