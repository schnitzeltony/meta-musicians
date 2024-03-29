HOMEPAGE = "http://zynaddsubfx.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=21fa88a5e50a1c608d22612c1fbe1971"

inherit cmake qemu-ext-musicians pkgconfig gtk-icon-cache features_check pack_audio_plugins bash-completion

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    virtual/libx11 \
    alsa-lib \
    jack \
    portaudio-v19 \
    dssi \
    lv2 \
    liblo \
    zlib \
    libmxml \
    libxpm \
"

CXXFLAGS += "-ftree-vectorize -ffast-math -DNDEBUG"

FILESEXTRAPATHS:prepend := "${THISDIR}/zyn:"

SRC_URI = " \
    gitsm://github.com/zynaddsubfx/zynaddsubfx.git;branch=master;protocol=https \
    file://0001-No-target-specific-asm.patch \
    file://0002-Controller-Spliter-align-Makefiles-for-cross-compili.patch \
    file://0003-Nio.cpp-Do-not-use-ps-aux-to-find-jack-busybox-s-ps-.patch \
    file://0004-Keep-our-build-flags.patch \
"
SRCREV = "be9fc502748c8b19fc4ab67751428734549d958b"
PV = "3.0.6"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    -DCompileTests=OFF \
    -DPluginLibDir=${baselib} \
"

do_configure:prepend() {
    # reconfigure?
    if [ ! -f ${WORKDIR}/lv2-ttl-generator-data ] ; then
        # We cannot run lv2-ttl-generator in cross environment so
        # manipulate CMakeLists.txt to keep commands in file
        sed -i \
            -e 's|../../lv2-ttl-generator|echo|g' \
            -e 's|echo $<TARGET_FILE.*|& >> ${WORKDIR}/lv2-ttl-generator-data|g' \
            `find ${S} -name CMakeLists.txt`
    else
        rm -f ${WORKDIR}/lv2-ttl-generator-data
    fi
}

do_compile:append() {
    # build ttl-files must be done in quemu
    for sofile in `cat ${WORKDIR}/lv2-ttl-generator-data`; do
        cd `dirname ${sofile}`
        echo "QEMU lv2-ttl-generator for ${sofile}..."
        ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', '${B}/src/Plugin/lv2-ttl-generator')} ${sofile} || echo "ERROR: for QEMU lv2-ttl-generator for ${sofile}!"
    done
}

PACKAGES =+ "${PN}-standalone"
FILES:${PN}-standalone = " \
    ${datadir}/applications \
    ${datadir}/pixmaps \
    ${bindir}/zynaddsubfx \
"

RDEPENDS:${PN_DSSI} += "${PN}"
RDEPENDS:${PN_LV2} += "${PN}"
RDEPENDS:${PN_VST} += "${PN}"
RDEPENDS:${PN}-standalone += "${PN}"

