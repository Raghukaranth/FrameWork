package pages;

import base.BaseUtils;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class Page extends BaseUtils {
    public Page() throws IOException, ParseException {
        this.waitForPageToLoad();
    }

    public abstract <T extends Page> T waitForPageToLoad();

}
