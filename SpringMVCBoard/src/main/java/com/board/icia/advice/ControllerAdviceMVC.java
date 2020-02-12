package com.board.icia.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.icia.exception.PageException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class ControllerAdviceMVC {
   @ExceptionHandler(PageException.class)
   public String except(PageException ex,RedirectAttributes attr) {
      attr.addFlashAttribute("msg", "페이지번호가 존재하지 않아요");
      return "redirect:/boardlist";
   }
}