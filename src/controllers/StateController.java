package controllers;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.State;
import data.StateDAO;

@Controller
@SessionAttributes({"stateList", "stateNum"})
public class StateController {
	@Autowired
	private StateDAO stateDao;

	@ModelAttribute("stateList")
	public Set<State> initStateSession()
	{
		Set<State> list = new LinkedHashSet();
		return list;
	}

	@ModelAttribute("stateNum")
	public Integer initNumber()
	{
		return 1;
	}

	@RequestMapping(path = "GetStateData.do", params = "name", method = RequestMethod.GET)
	public ModelAndView getByName(@RequestParam("name") String n, @ModelAttribute("stateList") Set<State> list)
	{
		State state = stateDao.getStateByName(n);
		
		list.add(state);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("state", state);
		mv.addObject("stateNum", state.getStateNum());
		
		return mv;
	}
	
	@RequestMapping(path = "GetStateData.do", params = "next", method = RequestMethod.GET)
	public ModelAndView getNextState( @ModelAttribute("stateList") Set<State> list,
			@ModelAttribute("stateNum") Integer num){
		
		State state = null;
		if(num < 50){
			state = stateDao.getStateNum(++num);
		}
		else{
			state = stateDao.getStateNum(1);
		}
		
		list.add(state);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("state", state);
		mv.addObject("stateNum", state.getStateNum());
		
		return mv;
	}
	
	@RequestMapping(path = "GetStateData.do", params = "previous", method = RequestMethod.GET)
	public ModelAndView getPrevState( @ModelAttribute("stateList") Set<State> list,
			@ModelAttribute("stateNum") Integer num){
		State state= null;
		if(num > 1){
			state = stateDao.getStateNum(--num);
		}
		else{
			state = stateDao.getStateNum(50);
		}
		 
		
		list.add(state);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("state", state);
		mv.addObject("stateNum", state.getStateNum());
		
		return mv;
	}
	
	
	@RequestMapping(path = "GetStateData.do", params = "abbrev", method = RequestMethod.GET)
	public ModelAndView getByAbbrev(@RequestParam("abbrev") String a, @ModelAttribute("stateList") Set<State> list)
	{
		State state = stateDao.getStateByAbbreviation(a);
		
		list.add(state);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("state", state);
		mv.addObject("stateNum", state.getStateNum());
		return mv;
	}

	@RequestMapping(path = "NewState.do", method = RequestMethod.POST)
	public ModelAndView newState(State state)
	{
		stateDao.addState(state);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		return mv;
	}
}
