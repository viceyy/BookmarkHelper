package pro.kisscat.www.bookmarkhelper.converter.support.impl;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pro.kisscat.www.bookmarkhelper.R;
import pro.kisscat.www.bookmarkhelper.converter.support.BasicBroswer;
import pro.kisscat.www.bookmarkhelper.converter.support.pojo.Bookmark;

/**
 * Created with Android Studio.
 * Project:BookmarkHelper
 * User:ChengLiang
 * Mail:stevenchengmask@gmail.com
 * Date:2016/10/9
 * Time:15:38
 */

public class ViaBroswer extends BasicBroswer {
    private static final String packageName = "mark.via";

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public int readBookmarkSum(Context context) {
        if (bookmarks == null) {
            readBookmark(context);
        }
        return bookmarks.size();
    }

    @Override
    public void fillDefaultIcon(Context context) {
        this.setIcon(context.getResources().getDrawable(R.drawable.ic_via));
    }

    @Override
    public void fillDefaultAppName(Context context) {
        this.setName(context.getString(R.string.broswer_name_show_via));
    }

    @Override
    public List<Bookmark> readBookmark(Context context) {
        if (bookmarks != null) {
            return bookmarks;
        }
        bookmarks = new LinkedList<>();
        return bookmarks;
    }

    @Override
    public int appendBookmark(Context context, List<Bookmark> bookmarks) {
        return 99;
    }

    public abstract class ViaBookmark extends Bookmark {
        @Setter
        @Getter
        private String folder;
        @Setter
        @Getter
        private int order;
    }
}
