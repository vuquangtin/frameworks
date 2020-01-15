package com.quartz.web.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.quartz.web.model.QuartzParam;
import com.quartz.web.model.QuartzWebJob;
import com.quartz.web.model.ResponseMessage;
import com.quartz.web.service.QuartzService;
import com.quartz.web.template.QuartzTemplate;
import com.quartz.web.util.JsonParser;
import com.quartz.web.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private QuartzService quartzService;

    /**
     * 通过API调用触发器
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "httpapi.action")
    public String httpTemplateForApi(HttpServletRequest request, HttpServletResponse response) {
        ResponseMessage<String> res = new ResponseMessage<String>(200, "success");
        String httpurl = RequestUtil.getString(request, "httpurl", null);
        String httpparam = RequestUtil.getString(request, "httpparam", null);
        String name = RequestUtil.getString(request, "name", null);
        String jobgroup = RequestUtil.getString(request, "jobgroup", null);
        String tiggergroup = RequestUtil.getString(request, "tiggergroup", null);
        String classgroup = "com.quartz.web.template.QuartzHttpTemplate";
        String cron = RequestUtil.getString(request, "cron", null);
        try {
            logger.info("httpurl:" + httpurl);
            logger.info("httpparam:" + httpparam);
            logger.info("name:" + name);
            logger.info("jobgroup:" + jobgroup);
            logger.info("tiggergroup:" + tiggergroup);
            logger.info("cron:" + cron);
            if (!Strings.isNullOrEmpty(name) && !Strings.isNullOrEmpty(cron) && !Strings.isNullOrEmpty(jobgroup) && !Strings.isNullOrEmpty(tiggergroup)) {
                QuartzWebJob quartzWebJob = new QuartzWebJob();
                quartzWebJob.setJobName(name);
                quartzWebJob.setJobGroupName(jobgroup);
                quartzWebJob.setTriggerName(name);
                quartzWebJob.setTriggerGroupName(tiggergroup);
                //quartzWebJob.setCls();
                Class jobClass = Class.forName(classgroup);
                quartzWebJob.setCls(jobClass);
                quartzWebJob.setTime(cron);

                Object jobInstance = jobClass.newInstance();

                if (jobInstance instanceof QuartzTemplate) {
                    List<QuartzParam> quartzParams = Lists.newArrayList();
                    QuartzParam quartzParam = new QuartzParam();
                    quartzParam.setJobname(name);
                    quartzParam.setParaname("httpurl");
                    quartzParam.setParavalue(httpurl);
                    quartzParams.add(quartzParam);

                    quartzParam = new QuartzParam();
                    quartzParam.setJobname(name);
                    quartzParam.setParaname("httpparam");
                    quartzParam.setParavalue(httpparam);
                    quartzParams.add(quartzParam);

                    quartzWebJob.setQuartzParamList(quartzParams);
                }
                logger.info("save job");
                this.quartzService.saveQuartzWebJob(quartzWebJob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonParser.simpleJson(res);
    }
}
