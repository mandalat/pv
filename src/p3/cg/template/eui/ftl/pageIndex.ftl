<!DOCTYPE html>
<html lang="en">
<head>
<title>列表页面</title> 
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta charset="UTF-8"> 
<link rel="stylesheet" href="$!{basePath}/css/ele_ui.css">
<script src="$!{basePath}/script/polyfill.min.js"></script>
<script src="$!{basePath}/script/qs.js"></script>
				<#assign columnName="" >	
				<#assign domainPropertyName="" >	
 <script> 
 	var ${lowerName} = #if($!{${lowerName}})$!{${lowerName}}#else{}#end;
      var pageinfo=[];
	  		#if($!{pageInfos})
				 #foreach($!{info} in $!{pageInfos}) 		
					var info={};
					<#list columnDatas as item>
						<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
							<#if item.columnType?upper_case == "DATETIME" ||item.columnType?upper_case == "DATE" || item.columnType?upper_case == "TIMESTAMP">
									info.${item.domainPropertyName}="$!dateTool.format("yyyy/MM/dd HH:mm:ss",$!{info.${item.domainPropertyName}})";
							<#else>
								info.${item.domainPropertyName}="$!{info.${item.domainPropertyName}}";
							</#if>
						</#if>
						<#if item.columnKey =='PRI' >
							<#assign columnName="${item.columnName}" >
							<#assign domainPropertyName="${item.domainPropertyName}" >
						</#if>
					</#list> 
					pageinfo.push(info);
	             #end
	    	 #end
  </script>
</head>
<div id="app">
<el-container style="border: 1px solid #eee; display:block ">
 <el-container style="display:block">
	 <el-header style="text-align: right; font-size: 12px ;padding:8px 0px 8px 0px;height:auto;display:flex;">
		<el-form :model="queryForm" ref="queryForm" label-width="80px" class="demo-ruleForm" style="width: 100%;">
		   <#list columnDatas as item>
				  	<#if item.columnKey != 'PRI'>
					<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
					<#if item.columnType?upper_case == "DATETIME" ||item.columnType?upper_case == "DATE" || item.columnType?upper_case == "TIMESTAMP">
							 <el-form-item label="${item.columnComment}" prop="${item.domainPropertyName}">
								<el-date-picker type="date" placeholder="选择日期" v-model="queryForm.${item.domainPropertyName}" value-format="yyyy-MM-dd"></el-date-picker>
							 </el-form-item>
					<#else>
						 	<el-form-item label="${item.columnComment}" prop="${item.domainPropertyName}">
								<el-input v-model="queryForm.${item.domainPropertyName}" name="${item.domainPropertyName}" ></el-input>
						  	</el-form-item> 
					</#if>
					</#if>
					</#if>
			</#list>
		 </el-form>
	 </el-header>

	 <el-header style="text-align: center; font-size: 12px ;padding:0px ;height:auto;margin-bottom: 11px;display:block;">
	 	<el-button type="primary" icon="el-icon-search"  @click="pageSize=10;currentPage=1;getTableData();">查询</el-button>
	 <el-button plain icon="el-icon-refresh"  @click="queryForm={}">重置</el-button>
		<el-button plain @click="dialogVisible=true;optype=0; queryForm={}" icon="el-icon-plus" >添加</el-button>  
		<el-button plain @click="deleteClick()" icon="el-icon-delete" >删除</el-button>
		<el-button plain @click="updateClick()"  icon="el-icon-edit" >修改</el-button>
		<el-button plain @click="detailClick()"  icon="el-icon-tickets" >详细</el-button>

	</el-header>
    
   <el-table
    :data="tableData"
    v-loading.fullscreen.lock="loading"
    height="350"
    border
    style="width: 100%;margin-bottom: 50px;"
	 :default-sort = "{prop: 'date', order: 'descending'}">

   <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <#list columnDatas as item>
				  	<#if item.columnName != 'id'>
						<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
								  	<el-form-item label="${item.columnComment}">
								            <span>{{ props.row.${item.domainPropertyName} }}</span> 
								    </el-form-item>
						</#if>
					</#if>
			</#list>
		
        </el-form>
      </template>
    </el-table-column>
 
           <#list columnDatas as item>
				  	<#if item.columnName != 'id'>
						<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
							 
								    <el-table-column
								      prop="${item.domainPropertyName}"
								      label="${item.columnComment}">
								    </el-table-column>
							 
						</#if>
					</#if>
			</#list>
			    
 <el-table-column
      fixed="right"
      label="选择"
      width="60">
      <template slot-scope="scope">
       <el-radio v-model="radio" :label="scope.$index" >&nbsp;</el-radio>
      </template>
    </el-table-column>
</el-table>
 </el-container>

 </el-container>
   <div class="block" style="width: 100%; height: 35px; text-align: center; bottom: 0px; line-height: 35px; position: fixed; z-index: 1000; background-color: rgb(255, 255, 255);"> 
		<el-pagination background
		  @size-change="handleSizeChange"
		  @current-change="handleCurrentChange"
		  :current-page.sync="currentPage"
		  :page-sizes="[10, 20, 50,100]"
		  :page-size.sync="pageSize"
		  layout="total, sizes, prev, pager, next, jumper"
		  :total.sync="total">
		</el-pagination>
	</div> 
	
	<el-dialog title="添加/修改" :visible.sync="dialogVisible"   >
		<el-form :model="queryForm" label-width="80px" class="demo-ruleForm" style="width: 100%;"  ref="addForm"  :rules="rules" >
		   <#list columnDatas as item>
				  	<#if item.columnKey != 'PRI'>
					<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
					<#if item.columnType?upper_case == "DATETIME" ||item.columnType?upper_case == "DATE" || item.columnType?upper_case == "TIMESTAMP">
							 <el-form-item label="${item.columnComment}" prop="${item.domainPropertyName}"  :label-width="formLabelWidth">
								<el-date-picker type="date" placeholder="选择日期" v-model="queryForm.${item.domainPropertyName}" value-format="yyyy-MM-dd"></el-date-picker>
							 </el-form-item>
					<#else>
						 	<el-form-item label="${item.columnComment}" prop="${item.domainPropertyName}" :label-width="formLabelWidth">
								<el-input v-model="queryForm.${item.domainPropertyName}" name="${item.domainPropertyName}"  auto-complete="off" ></el-input>
						  	</el-form-item> 
					</#if>
					</#if>
					</#if>
			</#list>
		 </el-form>
 			<div slot="footer" class="dialog-footer">
			    <el-button @click="dialogVisible = false;queryForm={}">取 消</el-button>
			    <el-button v-if="0==optype" type="primary" @click="doAdd()">新增</el-button>
				<el-button v-if="1==optype" type="primary" @click="doEdit()">修改</el-button>
			</div>
	</el-dialog>
  </div>

</body>
 
  <script src="$!{basePath}/script/vue.js"></script>
    <script src="$!{basePath}/script/axios.min.js"></script>
  <!-- 引入组件库 -->
  <script src="$!{basePath}/script/ele_ui.js"></script>

  <script>   
   axios.interceptors.request.use(function(request){
  if (request.data && (request.headers['Content-Type'].indexOf('application/x-www-form-urlencoded') !== -1)) {
    request.data = Qs.stringify(request.data);
    console.log(request.data);
  }
  return request
});
    new Vue({
      el: '#app',
	      methods: {
	  dateFormat:function(row, column) {  
      		var date = row[column.property];  
      		//console.log(date);
          if (null == date || date == {} || undefined == date.time || null == date.time || date.time=='' ) {  
             return "";  
          }   
         // console.log(date.time);
          return (new Date(date.time)).Format("yyyy-MM-dd");  
      },
      timeFormat:function(str) { 
      //console.log(str);   
          if (null == str || {} == str  || undefined == str.time || str.time=='' ) {  
             return "";  
          } 
           return (new Date(str.time)).Format("yyyy-MM-dd"); 
      }
      ,
      handleSizeChange:function(val) {
        this.pageSize=val;
        this.getTableData();
      },
      handleCurrentChange:function(val) {
        this.pageNo=val;
        this.getTableData();
      },
	   handleOpen:function(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose:function(key, keyPath) {
        console.log(key, keyPath);
      }, 
	  handleCommand:function(command) { 
				//window.location.href='./login.html';
      },
      resetForm:function(formName) {
        this.$refs[formName].resetFields();
      },
      getTableData:function(){
       this.loading=true;
       var that = this ;
                    axios({
						method: 'post',
						url: that.getUrl, 
						 headers: {
						    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
						  },
						data: {
					<#list columnDatas as item>
						${item.domainPropertyName}:that.queryForm.${item.domainPropertyName},
					</#list>
							pageNo:that.currentPage,
							pageSize:that.pageSize
						}
					}).then(function (response) {
						console.log(response);
						that.tableData=response.data.data;
						that.total= response.data.total;
						that.pageSize=response.data.pageSize;
						that.currentPage=response.data.pageNo;
						that.loading=false;
					}).catch(function (error) {
						console.log(error);
						 that.loading=false;
					});
					
        this.radio=-1;
      }, detailClick: function() {
		  if(this.radio =='-1' ){
						this.$notify.error({
						title: '提示信息',
						message: '请选择一条信息', 
						offset:60
				});
		  }else{
		  		  window.open('$!{basePath}/${bussPackage}/back/${lowerName}/toDetail.html?${domainPropertyName}='+this.tableData[this.radio].${domainPropertyName});
		  } 
      },doAdd:function(){
      	var that = this;
	  	 this.$refs['addForm'].validate(function(valid){
          if (valid) {
            							   		axios({
													method: 'post',
													url: that.addUrl, 
													headers: {
													    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
													},
													data: {
														<#list columnDatas as item>
															${item.domainPropertyName}:that.queryForm.${item.domainPropertyName},
														</#list>
														spec:''//没用的值
													}
												}).then(function (response) {
												if(response.data.success){
													that.$message({
												            type: 'success',
												            message: '操作成功!'
											          	});
											          	that.dialogVisible = false;
											          	that.tableData.push(response.data.obj); 
											          	that.total=that.total+1;
											          	that.queryForm={};
												}else{
													 	  that.$message({
												            type: 'info',
												            message: '操作失败!'
												          }); 
												}
													 	
												}).catch(function (error) {
													 	  that.$message({
												            type: 'info',
												            message: '操作失败!'
												          }); 
												});
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      updateClick:function(){
      	if(this.radio =='-1' ){
						this.$notify.error({
						title: '提示信息',
						message: '请选择一条信息', 
						offset:60
				});
		  }else{
	  	        this.dialogVisible=true;
	  	        this.queryForm= this.tableData[this.radio];
	  	        this.optype=1;
	  	 }
	  },doEdit:function(){
      	var that = this;
	  	 this.$refs['addForm'].validate(function(valid){
          if (valid) {
            							   		axios({
													method: 'post',
													url: that.editUrl, 
													headers: {
													    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
													},
													data: {
														<#list columnDatas as item>
															${item.domainPropertyName}:that.queryForm.${item.domainPropertyName},
														</#list>
														spec:''//没用的值
													}
												}).then(function (response) {
												if(response.data.success){
													that.$message({
												            type: 'success',
												            message: '操作成功!'
											          	});
											          	that.dialogVisible = false;  
											          	that.queryForm={};
												}else{
													 	  that.$message({
												            type: 'info',
												            message: '操作失败!'
												          }); 
												}
													 	
												}).catch(function (error) {
													 	  that.$message({
												            type: 'info',
												            message: '操作失败!'
												          }); 
												});
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      deleteClick: function() {
		  if(this.radio =='-1' ){
						this.$notify.error({
						title: '提示信息',
						message: '请选择一条信息', 
						offset:60
				});
		  }else{
		  var that = this;
		  		  this.$confirm('此操作将会删除该记录, 是否继续?', '提示', {
							          	confirmButtonText: '确定',
							          	cancelButtonText: '取消',
							          	type: 'warning'}).then(function() { 
							   			        axios({
													method: 'post',
													url: that.deleteUrl, 
													params: {
														${domainPropertyName}: that.tableData[that.radio].${domainPropertyName} 
													}
												}).then(function (response) {
													if(response.data.success){
														that.tableData.splice(that.radio, 1); 
														that.total= that.total-1;
													 	that.$message({
												            type: 'success',
												            message: '操作成功!'
											          	});
        												that.radio=-1;
													}else{
														that.$message({
												            type: 'info',
												            message: '操作失败!'
												          }); 
													}

												}).catch(function (error) {
													 	  that.$message({
												            type: 'info',
												            message: '操作失败!'
												          }); 
												});
						
							        	}).catch(function(){
							          		that.$message({
							            		type: 'info',
							            		message: '已取消'
							          		});           
					});
		  		  
		  		  
		  } 
      } 
    },
      data: function() {
        return {  
            getUrl: '$!{basePath}/${bussPackage}/back/${lowerName}/getList.html',
            editUrl:'$!{basePath}/${bussPackage}/back/${lowerName}/doEdit.html',
            deleteUrl:'$!{basePath}/${bussPackage}/back/${lowerName}/doDelete.html',
            addUrl:'$!{basePath}/${bussPackage}/back/${lowerName}/doAdd.html',
			radio:'-1', 
			tableData:  pageinfo,
			formLabelWidth: '120px',
		dialogVisible:false,
        currentPage: $!{pageInfos.index} ,
        total:$!{pageInfos.totalItem},
        pageSize:10,
        optype:0,//0为新增 1为修改
		queryForm: ${lowerName},
		loading:false,
        rules: {
          patientName: [
            { required: false, message: '请输入病人住院号', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          patientOffice: [
            { required: false, message: '请选择活动区域', trigger: 'change' }
          ],
          stopReason: [
            { required: true, message: '请选择终止原因', trigger: 'change' }
          ]
        }
		}
      }
    })
  </script>
</html>
