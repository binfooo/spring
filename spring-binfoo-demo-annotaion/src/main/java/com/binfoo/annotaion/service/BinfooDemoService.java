package com.binfoo.annotaion.service;

import com.binfoo.annotaion.condition.ServiceConditional;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@Lazy
@Primary
@Conditional(value = {
        ServiceConditional.class
})
public class BinfooDemoService {
}
