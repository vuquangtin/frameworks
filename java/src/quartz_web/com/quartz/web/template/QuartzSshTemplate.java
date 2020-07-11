package com.quartz.web.template;

import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.quartz.web.model.QuartzParam;
import com.quartz.web.service.QuartzService;
import com.quartz.web.util.ClassFactory;
import com.quartz.web.util.QuartzUtil;
import com.quartz.web.util.SSHHelper;

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
public class QuartzSshTemplate extends QuartzTemplate {

    private final static String host = "host";
    private final static String shell = "shell";
    private final static String port = "port";
    private final static String username = "username";
    private final static String password = "password";


    private final static Logger log = LoggerFactory.getLogger(QuartzSshTemplate.class);

    @Override
    public List<String> getParamName() {
        List<String> params = Lists.newArrayList();
        params.add(host);
        params.add(shell);
        params.add(username);
        params.add(password);
        params.add(port);
        return params;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getKey().getName();
        if (!Strings.isNullOrEmpty(jobName)) {
            QuartzService quartzService = ClassFactory.getBean(QuartzService.class);
            //根据JobName获取参数
            log.info("execute jobname:" + jobName);
            List<QuartzParam> params = quartzService.findQuartzParamByJobName(jobName);
            if (params != null) {
                log.info("exec ssh templeate job param:" + params.toString());
                //验证参数
                if (params.size() > 0) {
                    Map<String, String> mparas = QuartzUtil.getParaMap(params);
                    try {
                        String tusername = mparas.get(username);
                        String tpassword = mparas.get(password);
                        String tshell = mparas.get(shell);
                        String thost = mparas.get(host);
                        int tport = Integer.valueOf(mparas.get(port));

                        String execLog = SSHHelper.exec(thost, tusername, tpassword, tport, tshell);
                        log.info("job :" + jobName + " exec result:" + execLog);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    log.info("exec ssh template job param is no exec this job!");
                }
            }
        }
    }
}
