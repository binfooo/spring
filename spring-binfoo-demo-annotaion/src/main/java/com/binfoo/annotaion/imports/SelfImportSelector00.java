package com.binfoo.annotaion.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@SuppressWarnings("unused")
public class SelfImportSelector00 implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // for (String annotationType : importingClassMetadata.getAnnotationTypes()) {
        //     System.out.println("==============");
        //     System.out.println(annotationType);
        //     System.out.println("==============");
        // }
        return new String[]{"com.binfoo.annotaion.imports.SelfImport00"};
    }
}
