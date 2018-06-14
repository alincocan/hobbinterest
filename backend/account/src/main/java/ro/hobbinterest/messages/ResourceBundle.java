package ro.hobbinterest.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class ResourceBundle {


    private static final long serialVersionUID = 4403931990849871689L;

    @Autowired
    private ResourceBundleMessageSource resourceBundle;

    public String getMessage(String key, Object... params) {
        return resourceBundle.getMessage(key, params, LocaleContextHolder.getLocale());
    }

}
