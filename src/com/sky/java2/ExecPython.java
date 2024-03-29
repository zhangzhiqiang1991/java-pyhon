package com.sky.java2;

import java.util.Map;
import java.util.Map.Entry;

import org.python.util.PythonInterpreter;

/*enum的这个用法,可以作为变种的安全单例,值得借鉴哦 ^_^ */
public enum ExecPython {
	INSTANCE;

	public void execute(String scriptFile, Map<String, String> properties) {
		// 获取python解释器
		final PythonInterpreter inter = JythonEnvironment.getInstance().getPythonInterpreter();

		// 设置python属性,python脚本中可以使用
		for (Entry<String, String> entry : properties.entrySet()) {
			inter.set(entry.getKey(), entry.getValue());
		}

		try {
			// 通过python解释器调用python脚本
			inter.execfile(scriptFile);
		} catch (Exception e) {
			System.out.println("ExecPython encounter exception:" + e);
		}
	}
}
