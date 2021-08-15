HOMEPAGE = "http://tomszilagyi.github.io/plugins/ir.lv2/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS += " \
    gtk+ \
    lv2 \
    libsndfile1 \
    libsamplerate0 \
    zita-convolver \
"

SRC_URI = " \
    git://github.com/tomszilagyi/ir.lv2.git;branch=${IR_LV2_BRANCH} \
    file://0001-Makefile-Do-not-add-usr-include-to-include-paths.patch \
    file://0002-Makefile-force-correct-installation.patch \
    file://0003-Fix-build-with-lv2-1.1.18.patch \
"
S = "${WORKDIR}/git"

LV2_NAME = "http://tomszilagyi.github.io/plugins/lv2/ir"
IR_LV2_VARIANT ?= ""
IR_LV2_DOAP_EXTENSION ?= ""

do_compile:prepend() {
    for file in `grep -rl '${LV2_NAME}'`; do
        sed -i 's|${LV2_NAME}|${LV2_NAME}_${IR_LV2_VARIANT}|g' $file
    done
    for file in `grep -rl ir.so`; do
        sed -i 's|ir.so|ir_${IR_LV2_VARIANT}.so|g' $file
    done
    for file in `grep -rl ir_gui.so`; do
        sed -i 's|ir_gui.so|ir_gui_${IR_LV2_VARIANT}.so|g' $file
    done
}

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
    mv ${D}${libdir}/lv2/ir.lv2 ${D}${libdir}/lv2/ir_${IR_LV2_VARIANT}.lv2
    mv ${D}${libdir}/lv2/ir_${IR_LV2_VARIANT}.lv2/ir.ttl ${D}${libdir}/lv2/ir_${IR_LV2_VARIANT}.lv2/ir_${IR_LV2_VARIANT}.ttl 
    sed -i 's|ir.ttl|ir_${IR_LV2_VARIANT}.ttl|g' ${D}${libdir}/lv2/ir_${IR_LV2_VARIANT}.lv2/manifest.ttl
    sed -i 's|doap:name "IR"|doap:name "IR (${IR_LV2_DOAP_EXTENSION})"|g' ${D}${libdir}/lv2/ir_${IR_LV2_VARIANT}.lv2/ir_${IR_LV2_VARIANT}.ttl
}

FILES:${PN} += "${libdir}/lv2/"
