package com.example.jooq;

import org.jooq.ExecuteContext;
import org.jooq.ExecuteListener;

public class LoggingListener implements ExecuteListener {
    public void start(final ExecuteContext ctx) {
    }

    public void renderStart(final ExecuteContext ctx) {
    }

    public void renderEnd(final ExecuteContext ctx) {

    }

    public void prepareStart(final ExecuteContext ctx) {

    }

    public void prepareEnd(final ExecuteContext ctx) {

    }

    public void bindStart(final ExecuteContext ctx) {

    }

    public void bindEnd(final ExecuteContext ctx) {

    }

    public void executeStart(final ExecuteContext ctx) {
        System.out.println("Executing the query " + ctx.sql());

    }

    public void executeEnd(final ExecuteContext ctx) {

    }

    public void outStart(final ExecuteContext ctx) {

    }

    public void outEnd(final ExecuteContext ctx) {

    }

    public void fetchStart(final ExecuteContext ctx) {

    }

    public void resultStart(final ExecuteContext ctx) {

    }

    public void recordStart(final ExecuteContext ctx) {

    }

    public void recordEnd(final ExecuteContext ctx) {

    }

    public void resultEnd(final ExecuteContext ctx) {

    }

    public void fetchEnd(final ExecuteContext ctx) {

    }

    public void end(final ExecuteContext ctx) {

    }

    public void exception(final ExecuteContext ctx) {

    }

    public void warning(final ExecuteContext ctx) {

    }
}
