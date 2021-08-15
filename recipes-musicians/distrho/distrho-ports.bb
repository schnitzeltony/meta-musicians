SUMMARY = "Collection of synthesizers and plugins"
HOMEPAGE = "http://distrho.sourceforge.net/ports"
LICENSE = "GPLv2 & LGPLv3"
LIC_FILES_CHKSUM = " \
    file://doc/GPL.txt;md5=4641e94ec96f98fabc56ff9cc48be14b \
    file://doc/LGPL.txt;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

SRC_URI = " \
    git://github.com/DISTRHO/DISTRHO-Ports.git \
    file://0001-Modify-ttl-generation-target-so-we-can-sed-it-to-cor.patch \
    \
    http://linuxsynths.com/ObxdPatchesDemos/ObxdPatchesBrian-01.tar.gz;name=linuxsynths-obxd-patches1;subdir=linuxsynths-obxd-patches \
    \
    http://linuxsynths.com/VexPatchesDemos/VexPatches01.tar.gz;name=linuxsynths-vex-patches1;subdir=linuxsynths-vex-patches \
    http://linuxsynths.com/VexPatchesDemos/VexPatches02.tar.gz;name=linuxsynths-vex-patches2;subdir=linuxsynths-vex-patches \
"

SRCREV = "2131ac41eef308c2ba11df6f1ae3985f3c868485"
S = "${WORKDIR}/git"
PV = "2021-03-15+git${SRCPV}"

SRC_URI[linuxsynths-obxd-patches1.md5sum] = "32244f847a54a71ee3c25079df5c8b84"
SRC_URI[linuxsynths-obxd-patches1.sha256sum] = "246fccadd71bb9f0606a95bf7b0aee7807fd3a14f754367425423a51c31e160e"

SRC_URI[linuxsynths-vex-patches1.md5sum] = "c03f8ac9eaf3fabb3c98af5cb27a5edb"
SRC_URI[linuxsynths-vex-patches1.sha256sum] = "1a32ba4ba52d0efcd2214e52ecf9ea71885d110261c2b26e23ccdbd0960b6f60"
SRC_URI[linuxsynths-vex-patches2.md5sum] = "a3d00bf9eb7e2381ffc56f3e79e067ec"
SRC_URI[linuxsynths-vex-patches2.sha256sum] = "378cff261dab333c5f29246b6f3f557e0461e8bc230519da3a1a9049cbd437d5"

REQUIRED_DISTRO_FEATURES = "x11 opengl"

inherit meson lv2-turtle-helper features_check pack_audio_plugins

DEPENDS += " \
    virtual/libgl \
    alsa-lib \
    libx11 \
    libxext \
    libxcursor \
    freetype \
    ladspa-sdk \
"

LV2_TTL_GENERATOR = "${B}/libs/lv2-ttl-generator/lv2_ttl_generator"

do_ttl_sed() {
    sed -i 's|%PLUGIN_INFO_FILE%|${LV2_PLUGIN_INFO_FILE}|g' `find ${S} -name meson.build`
    sed -i 's|$GEN ./$FILE|echo "`pwd`/$FILE" >> ${LV2_PLUGIN_INFO_FILE}|g' `find ${S}/scripts -name *.sh`
}

EXTRA_OEMESON += " \
    -Doptimizations=false \
"

# ttl-generator bindir for distrho-ports-extra
SYSROOT_DIRS:append = " ${bindir}"

PACKAGES =+ "${PN}-presets"
RDEPENDS:${PN}-presets = "${PN_LV2}"

FILES:${PN}-presets = "${libdir}/lv2/*.preset.lv2"

# dummy pack ttl-generator for distrho-ports-extra
PACKAGES =+ "${PN}-ttl-generator"
FILES:${PN}-ttl-generator += " \
    ${bindir}/lv2_ttl_generator \
    ${bindir}/scripts \
    ${libdir}/libs \
"

# Have not found what causes stripping - debugging of plugins is unlikely
INSANE_SKIP:${PN} = "already-stripped"
