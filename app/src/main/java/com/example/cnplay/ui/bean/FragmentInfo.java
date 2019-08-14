package com.example.cnplay.ui.bean;

/**
 * <pre>
 *     author:LHT
 *     date:20190812
 * </pre>
 */
public class FragmentInfo {

    private String title;
    private Class fragment;

    public FragmentInfo(String title, Class fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
