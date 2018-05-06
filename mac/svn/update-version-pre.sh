#!/bin/sh
source batch-copy.sh
SOUR_DIR=/opt/respository/svn-ecstore/ecstore/doc/升级包/patch-onex-38\~53/patch-onex_ecstore_source-2.3.55/ecstore
#SOUR_DIR=/Users/chy/Documents/workspace/merge/patch-source-20151019/ecstore_source
REF_DIR=/opt/respository/svn-ecstore/ecstore/trunk/ecstore_online
#DES_DIR=/opt/respository/svn-ecstore/ecstore-update/patch-2.3.40/ecstore
DES_DIR=/Users/chy/Documents/workspace/merge/patch-2.3.55-source-all/ecstore_product
#DES_DIR=/opt/respository/svn-ecstore/testaa
CP_APP_FILES=app
DES_APP_FILES=app
CP_CUS_FILES=app
DES_CUS_FILES=custom_smhw2015
CP_PUB_FILES=public
DES_PUB_FILES=public
CP_THEME_FILES=themes
DES_THEME__FILES=themes

if [ -e  $SOUR_DIR'/'$CP_APP_FILES ];then
	#app
	copy_full  $SOUR_DIR  $DES_DIR  $CP_APP_FILES
	cover_copy_bak  $SOUR_DIR  $REF_DIR  $DES_DIR  $CP_APP_FILES $DES_APP_FILES
	#custom_smhw2015
	cover_copy  $SOUR_DIR  $REF_DIR  $DES_DIR  $CP_CUS_FILES $DES_CUS_FILES
	cover_copy_bak  $SOUR_DIR  $REF_DIR  $DES_DIR  $CP_CUS_FILES $DES_CUS_FILES
fi
if [ -e  $SOUR_DIR'/'$CP_PUB_FILES ];then
	#public
	copy_full  $SOUR_DIR  $DES_DIR  $CP_PUB_FILES
	cover_copy_bak  $SOUR_DIR  $REF_DIR  $DES_DIR  $CP_PUB_FILES $DES_PUB_FILES
fi
if [ -e  $SOUR_DIR'/'$CP_THEME_FILES ];then
	#themes
	copy_full  $SOUR_DIR  $DES_DIR  $CP_THEME_FILES
	cover_copy_bak  $SOUR_DIR  $REF_DIR  $DES_DIR  $CP_THEME_FILES $DES_THEME__FILES
fi
