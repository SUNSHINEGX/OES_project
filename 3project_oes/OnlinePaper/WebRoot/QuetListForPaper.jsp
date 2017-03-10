<%@ page language="java" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="/WEB-INF/displaytag-11.tld"%>

	  <s:if test="{questionList!=null}" >
	      asdfafafasfadfadf000000000
         <s:set name="questionList" value="questionList" scope="session"/>		
      </s:if>
<div id="QestPaperLayer1">
	<table width="272" height="87" border="1">
		<tr>
			<td colspan="4" bgcolor="#996699">
				<div align="center">
					题库列表
				</div>
			</td>
		</tr>
		<tr>
			<td width="26">
				<input name="selAll" onclick="selectAll()" type="checkbox" id="c" />
			</td>
			<td width="40">
				题型
			</td>
			<td width="149">
				题干
			</td>
			<td width="29">
				占分
			</td>
		</tr>
		<s:iterator value="#session.questionList" id="iterOptions">
			<tr>
				<td>
					<input name="questionIDs" type="checkbox"
						value=<s:property value="#iterOptions.questId"  /> />
				</td>
				<td>
					<s:property value="#iterOptions.type" />
				</td>
				<td>
					<a
						href="javascript:showPopup(200,150,<s:property value="#iterOptions.questId"  />)"
						onmouseover="javascript:showPopup(200,150,<s:property value="#iterOptions.questId"  />)"
						onmouseout="javascript:hidePopup()"><s:property
							value="#iterOptions.mainContent" />
					</a>
				</td>
				<td>
					<s:property value="#iterOptions.score" />
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
<div id="QestPaperLayer2">
	<table width="274" height="82" border="1">
		<tr>
			<td colspan="4" bgcolor="#996699">
				<div align="center">
					试卷题库列表
				</div>
			</td>
		</tr>
		<tr>
			<td width="25">
				<input name="selAll2" onclick="selectAll2()" type="checkbox" />
			</td>
			<td width="40">
				题型
			</td>
			<td width="153">
				题干
			</td>
			<td width="28">
				占分
			</td>
		</tr>
		<s:iterator value="#session.paperQuestionList" id="iterOptions2">
		    <input name="hideQuestIDs" type="hidden" value="<s:property value="#iterOptions2.questId"  />" />
			<tr>

				<td>
					<input name="questionIDs2" type="checkbox"
						value="<s:property value="#iterOptions2.questId"  />" />
				</td>
				<td>
					<s:property value="#iterOptions2.type" />
				</td>
				<td>
					<a
						href="javascript:showPopup(200,150,<s:property value="#iterOptions2.questId"  />)"
						onmouseover="javascript:showPopup(200,150,<s:property value="#iterOptions2.questId"  />)"
						onmouseout="javascript:hidePopup()"><s:property
							value="#iterOptions2.mainContent" /> </a>
				</td>
				<td>
					<s:property value="#iterOptions2.score" />
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
<div id="QestPaperLayer3">
	<table width="72" height="83" border="0">
		<tr>
			<td>
				<input type="button" name="SelQes" onclick="javascript:selQes()"
					size=8 value="选题入卷-&gt;" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" name="UnSelQes" onclick="javascript:unSelQes()"
					size=8 value="&lt;-选题出卷" />
			</td>
		</tr>
	</table>
</div>



